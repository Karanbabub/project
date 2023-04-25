import { Component, OnInit } from '@angular/core';
import { ElectronicsService } from '../../service/electronics.service';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';
import { take } from 'rxjs';
import { Order } from '../../model/order';

@Component({
  selector: 'app-c-order',
  templateUrl: './c-order.component.html',
  styleUrls: ['./c-order.component.scss'],
})
export class COrderComponent implements OnInit {
  orderList: Order[] = [];

  constructor(
    private gService: ElectronicsService,
    private router: Router,
    private datePipe: DatePipe
  ) {
    this.gService.isClientLoginPresent();
  }

  ngOnInit(): void {
    this.getOrderList();
  }
  getOrderList(): void {
    this.gService
      .orderList(this.gService.getClientAuthorization())
      .pipe(take(1))
      .subscribe(
        (res: any) => {
          console.log('************', res);
          if (!!res && Array.isArray(res)) {
            this.orderList = res;
          }
        },
        (err) => {
          console.log('Error');
        }
      );
  }
  getDate(d: string | undefined): any {
    //return  !!d ? this.datePipe.transform(new Date(d),"" )?.toString(): "";
    //return this.datePipe.transform(d,"").toString();
    let ans: any;
    console.log('DDDDDD', d);
    if (!!d && d !== null) {
      ans = this.datePipe.transform(d, 'shortDate') || null;
      console.log('@@@@@@@@', ans);
    }
    return ans;
  }

  addPayment(order: Order): void {
    this.router.navigate([
      `/client/payment/${order?.orderId}/${order?.totalPrice}`,
    ]);
  }
}
