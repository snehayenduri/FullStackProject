import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { CustomerHomeComponent } from './customer/customer-home/customer-home.component';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { CustomerRegistrationComponent } from './customer/customer-registration/customer-registration.component';
import { CustomerCartComponent } from './customer/customer-cart/customer-cart.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RetailerLoginComponent } from './retailer/retailer-login/retailer-login.component';
import { CustomerLogoutComponent } from './customer/customer-logout/customer-logout.component';
import { CategoriesComponent } from './customer/categories/categories.component';
import { CustomerProductsearchComponent } from './customer/customer-productsearch/customer-productsearch.component';
import { MenClothesComponent } from './customer/categories/men-clothes/men-clothes.component';
import { WomenClothesComponent } from './customer/categories/women-clothes/women-clothes.component';
import { MobilephonesComponent } from './customer/categories/mobilephones/mobilephones.component';
import { TelevisionComponent } from './customer/categories/television/television.component';
import { SortbynameComponent } from './customer/customer-home/sortbyname/sortbyname.component';
import { SortbypriceLowtohighComponent } from './customer/customer-home/sortbyprice-lowtohigh/sortbyprice-lowtohigh.component';
import { SortbypriceHightolowComponent } from './customer/customer-home/sortbyprice-hightolow/sortbyprice-hightolow.component';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { PlaceOrderComponent } from './customer/place-order/place-order.component';
import { RetailerHomeComponent } from './retailer/retailer-home/retailer-home.component';
import { RetailerProductComponent } from './retailer/retailer-product/retailer-product.component';
import { AddProductComponent } from './retailer/add-product/add-product.component';
import { UpdateProductComponent } from './retailer/update-product/update-product.component';
import { RetailerProfileComponent } from './retailer/retailer-profile/retailer-profile.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RetailerHeaderComponent } from './retailer/retailer-header/retailer-header.component';


import { RetailerFooterComponent } from './retailer/retailer-footer/retailer-footer.component';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminProductComponent } from './admin/admin-product/admin-product.component';
import { AdminProfileComponent } from './admin/admin-profile/admin-profile.component';
import { AdminRetailerComponent } from './admin/admin-retailer/admin-retailer.component';
import { AdminUpdateComponent } from './admin/admin-update/admin-update.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    ErrorComponent,
    CustomerHomeComponent,
    CustomerLoginComponent,
    CustomerRegistrationComponent,
    CustomerCartComponent,
    RetailerLoginComponent,
    CustomerLogoutComponent,
    CategoriesComponent,
    CustomerProductsearchComponent,
    MenClothesComponent,
    WomenClothesComponent,
    MobilephonesComponent,
    TelevisionComponent,
    SortbynameComponent,
    SortbypriceLowtohighComponent,
    SortbypriceHightolowComponent,
    CustomerProfileComponent,
    PlaceOrderComponent,
    RetailerHomeComponent,
    RetailerProductComponent,
    AddProductComponent,
    UpdateProductComponent,
    RetailerProfileComponent,
    HeaderComponent,
    FooterComponent,
    RetailerHeaderComponent,
    
    RetailerFooterComponent,
         AdminHeaderComponent,
         AdminLoginComponent,
         AdminProductComponent,
         AdminProfileComponent,
         AdminRetailerComponent,
         AdminUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,ReactiveFormsModule,HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
