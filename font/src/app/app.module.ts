import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { DatePipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutusComponent } from './components/aboutus/aboutus/aboutus.component';
import { AHomeComponent } from './components/admin/a-home/a-home.component';
import { AddproductComponent } from './components/admin/addproduct/addproduct.component';
import { HeaderComponent } from './components/admin/header/header.component';
import { LoginComponent } from './components/admin/login/login.component';
import { ProductlistComponent } from './components/admin/productlist/productlist.component';
import { ChangePasswordComponent } from './components/change-password/change-password/change-password.component';
import { CCartComponent } from './components/client/c-cart/c-cart.component';
import { CHeaderComponent } from './components/client/c-header/c-header.component';
import { CHomeComponent } from './components/client/c-home/c-home.component';
import { CLoginComponent } from './components/client/c-login/c-login.component';
import { COrderComponent } from './components/client/c-order/c-order.component';
import { CPaymentComponent } from './components/client/c-payment/c-payment.component';
import { CSignupComponent } from './components/client/c-signup/c-signup.component';
import { ContactusComponent } from './components/contactus/contactus/contactus.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password/forgot-password.component';
import { LandingComponent } from './components/landing/landing/landing.component';
import { PagingComponent } from './components/paging/paging/paging.component';
// import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    AddproductComponent,
    ProductlistComponent,
    LandingComponent,
    CHeaderComponent,
    CHomeComponent,
    CLoginComponent,
    COrderComponent,
    CPaymentComponent,
    CSignupComponent,
    CCartComponent,
    PagingComponent,
    ForgotPasswordComponent,
    ChangePasswordComponent,
    AboutusComponent,
    ContactusComponent,
    AppComponent,
    AboutusComponent,
    ContactusComponent,
    ForgotPasswordComponent,
    ChangePasswordComponent,
    PagingComponent,
    AHomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatButtonModule,
    MatAutocompleteModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatToolbarModule,
    MatButtonToggleModule,
    MatInputModule,
    MatNativeDateModule,
    MatMenuModule,
    MatSnackBarModule,
    MatRippleModule,
    ReactiveFormsModule,
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {}
