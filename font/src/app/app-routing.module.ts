import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/admin/login/login.component';
import { AboutusComponent } from './components/aboutus/aboutus/aboutus.component';
import { ChangePasswordComponent } from './components/change-password/change-password/change-password.component';
import { ContactusComponent } from './components/contactus/contactus/contactus.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password/forgot-password.component';
import { CSignupComponent } from './components/client/c-signup/c-signup.component';
import { CLoginComponent } from './components/client/c-login/c-login.component';
import { CHomeComponent } from './components/client/c-home/c-home.component';
import { CCartComponent } from './components/client/c-cart/c-cart.component';
import { COrderComponent } from './components/client/c-order/c-order.component';
import { CPaymentComponent } from './components/client/c-payment/c-payment.component';
import { AddproductComponent } from './components/admin/addproduct/addproduct.component';
import { ProductlistComponent } from './components/admin/productlist/productlist.component';
import { AHomeComponent } from './components/admin/a-home/a-home.component';
import { HomeComponent } from './components/home/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'contact-us', component: ContactusComponent },
  { path: 'about-us', component: AboutusComponent },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'change-password', component: ChangePasswordComponent },
  { path: 'c-register', component: CSignupComponent },
  { path: 'client-login', component: CLoginComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'client',
    children: [
      { path: 'home', component: CHomeComponent },
      { path: 'cart', component: CCartComponent },
      { path: 'order', component: COrderComponent },
      { path: 'payment/:orderId/:totalPrice', component: CPaymentComponent },
    ],
  },
  {
    path: 'admin',
    children: [
      { path: 'home', component: AHomeComponent },
      { path: 'addproduct', component: AddproductComponent },
      { path: 'listproduct', component: ProductlistComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
