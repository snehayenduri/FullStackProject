import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminProductComponent } from './admin/admin-product/admin-product.component';
import { AdminRetailerComponent } from './admin/admin-retailer/admin-retailer.component';
import { AdminUpdateComponent } from './admin/admin-update/admin-update.component';
import { CategoriesComponent } from './customer/categories/categories.component';
import { MenClothesComponent } from './customer/categories/men-clothes/men-clothes.component';
import { MobilephonesComponent } from './customer/categories/mobilephones/mobilephones.component';
import { TelevisionComponent } from './customer/categories/television/television.component';
import { WomenClothesComponent } from './customer/categories/women-clothes/women-clothes.component';
import { CustomerCartComponent } from './customer/customer-cart/customer-cart.component';
import { CustomerHomeComponent } from './customer/customer-home/customer-home.component';
import { SortbynameComponent } from './customer/customer-home/sortbyname/sortbyname.component';
import { SortbypriceHightolowComponent } from './customer/customer-home/sortbyprice-hightolow/sortbyprice-hightolow.component';
import { SortbypriceLowtohighComponent } from './customer/customer-home/sortbyprice-lowtohigh/sortbyprice-lowtohigh.component';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { CustomerProductsearchComponent } from './customer/customer-productsearch/customer-productsearch.component';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { CustomerRegistrationComponent } from './customer/customer-registration/customer-registration.component';
import { PlaceOrderComponent } from './customer/place-order/place-order.component';
import { ErrorComponent } from './error/error.component';
import { AddProductComponent } from './retailer/add-product/add-product.component';
import { RetailerHomeComponent } from './retailer/retailer-home/retailer-home.component';
import { RetailerLoginComponent } from './retailer/retailer-login/retailer-login.component';
import { RetailerProductComponent } from './retailer/retailer-product/retailer-product.component';
import { RetailerProfileComponent } from './retailer/retailer-profile/retailer-profile.component';
import { UpdateProductComponent } from './retailer/update-product/update-product.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [


  /////////////////////////////////////////////////////////////sneha
  {path:"",component:WelcomeComponent},
  {path:"customerLogin", component:CustomerLoginComponent},
  {path:"customerHome",component:CustomerHomeComponent},
  {path:"customerRegister", component:CustomerRegistrationComponent},
  {path:"retailerLogin", component:RetailerLoginComponent},
  {path:"customerProfile", component:CustomerProfileComponent},

  {path:"retailerHome", component:RetailerHomeComponent},
  {path:"retailerProfile", component:RetailerProfileComponent},
  {path:"addProduct", component:AddProductComponent},
  {path:"retailerProduct", component:RetailerProductComponent, 
  children:[{path:"updateProduct", component:UpdateProductComponent},
             
]},

  
  

  ///////////////////////////////////narmada part
  {path:"categories",component:CategoriesComponent},
  {path:"productsearch",component:CustomerProductsearchComponent},
  {path:"menclothes",component:MenClothesComponent},
  {path:"womenclothes",component:WomenClothesComponent},
  {path:"mobiles",component:MobilephonesComponent},
  {path:"television",component:TelevisionComponent},
  {path:"sortbyname",component:SortbynameComponent},
  {path:"sortbypriceLowToHigh",component:SortbypriceLowtohighComponent},
  {path:"sortbypriceHighToLow",component:SortbypriceHightolowComponent},



  {path: 'admin-login', component: AdminLoginComponent},
  {path: 'app-admin-header', component: AdminHeaderComponent},
  {path: 'admin-products', component: AdminProductComponent},
  
  {path: 'admin-retailer', component: AdminRetailerComponent},
  {path: 'admin-update', component: AdminUpdateComponent},

  {path: "CustomerCart", component: CustomerCartComponent},
  {path:"placeorder", component:PlaceOrderComponent},
  {path:"**", component:ErrorComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
