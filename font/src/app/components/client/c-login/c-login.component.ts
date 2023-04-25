import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { take } from 'rxjs';
import { ElectronicsService } from '../../service/electronics.service';

@Component({
  selector: 'app-c-login',
  templateUrl: './c-login.component.html',
  styleUrls: ['./c-login.component.scss'],
})
export class CLoginComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  email: string = '';
  password: string = '';
  clientLoginForm: any = new FormGroup({});

  constructor(
    private router: Router,
    private gservice: ElectronicsService,
    private fb: FormBuilder
  ) {
    const pattern =
      /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    this.clientLoginForm = this.fb.group({
      email: ['', [Validators.required, Validators.pattern(pattern)]],
      password: [
        null,
        Validators.compose([Validators.required, Validators.minLength(8)]),
      ],
    });
  }
  signIn(): void {
    const body = {
      emailID: this.clientLoginForm.controls['email'].value,
      password: this.clientLoginForm.controls['password'].value,
    };
    console.log('=======>', body);
    this.gservice
      .clientSignIn(body)
      .pipe(take(1))
      .subscribe(
        (res: any) => {
          console.log('*****', res);
          if (res && res?.customerId) {
            // alert("Login sucessful");
            this.gservice.storeClientAuthorization(res?.customerId);
            let userName = '';
            if (res?.firstName) {
              userName += res?.firstName;
            }
            if (res?.lastName) {
              userName += ' ' + res?.lastName;
            }
            this.gservice.storeClientUserName(userName);
            this.router.navigate(['/client/home']);
          }
        },
        (err) => {
          console.log('Error  ', err);
          alert('Something going wrong in login!!pl try again');
        }
      );
  }

  routeToNewUser(): void {
    this.router.navigate(['/c-register']);
  }

  routeToForgotPassword(): void {
    this.router.navigate(['/forgot-password']);
  }
}
