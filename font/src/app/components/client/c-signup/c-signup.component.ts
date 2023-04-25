import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { take } from 'rxjs';
import { ElectronicsService } from '../../service/electronics.service';

@Component({
  selector: 'app-c-signup',
  templateUrl: './c-signup.component.html',
  styleUrls: ['./c-signup.component.scss'],
})
export class CSignupComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  constructor(
    private router: Router,
    private datePipe: DatePipe,
    private gservice: ElectronicsService
  ) {}
  firstName: string = '';
  lastName: string = '';
  dateOfBirth: string = '';
  phoneNumber: string = '';
  district: string = '';
  state: string = '';
  zipCode: string = '';
  emailID: string = '';
  gender: string = 'male';
  password: string = '';

  setDOB(ev: any): void {
    const date: any = this.datePipe.transform(ev?.value, 'yyyy-MM-dd');
    this.dateOfBirth = date;
  }

  signup(): void {
    if (this.firstName === '' || this.firstName.length < 3) {
      alert('FirstName must contain atleast 3 characters');
      return;
    }
    if (this.lastName === '' || this.lastName.length < 3) {
      alert('LastName must contain atleast 3 characters');
      return;
    }

    if (
      this.phoneNumber === '' ||
      this.phoneNumber.length < 10 ||
      this.phoneNumber.length > 10
    ) {
      alert('Phone must contain atleast 10 characters');
      return;
    }
    if (this.district === '' || this.district.length < 3) {
      alert('District must contain atleast 3 characters');
      return;
    }
    if (this.state === '' || this.state.length < 3) {
      alert('State must contain atleast 3 characters');
      return;
    }
    if (this.zipCode === '' || this.zipCode.length < 6) {
      alert('pincode must contain atleast 6 characters');
      return;
    }
    //alert("sucess")
    const body: any = {
      firstName: this.firstName,
      lastName: this.lastName,
      dateOfBirth: this.dateOfBirth,
      phoneNumber: this.phoneNumber,
      district: this.district,
      state: this.state,
      zipCode: this.zipCode,
      emailID: this.emailID,
      gender: this.gender,
      password: this.password,
    };
    console.log('=======>', body);
    this.gservice
      .signUp(body)
      .pipe(take(1))
      .subscribe(
        (res: any) => {
          console.log('*****', res);
          if (res && res?.customerId) {
            alert('Registration sucessful');
            this.router.navigate(['/client-login']);
          }
        },
        (err) => {
          console.log('Error  ', err);
          alert('Something going wrong!!pl try again');
        }
      );
  }
}
