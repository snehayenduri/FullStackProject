import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../customer/Cart';
import { Product } from '../customer/customer-productsearch/Product';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  productName:string="";
  productDetail:Product;
  keyword: string;
  loginOrLogout: string;
  cQty: number;
  uId : number;
  constructor(
    private router : Router,
    private productService : CustomerService) { }

  ngOnInit(): void {

  }
  onSearch(){
    localStorage.setItem('searchProductName',this.productName);
    //console.log(this.productDetail);
    this.router.navigate(['productsearch']);
  }
  logout()
  {
    localStorage.removeItem("customerId");
    this.router.navigate(['customerLogin']);

  }
  
    
  //   if(parseInt(sessionStorage.getItem('user'))>0)
  //   {
  //     this.uId = parseInt(sessionStorage.getItem('user'));
  //     this.loginOrLogout = 'Logout';
  //     this._customerService.getMyCart(sessionStorage.getItem('user'))
  //     .subscribe((data:Cart[])=>{
  //       this.cQty = data.length;
  //     })
  //   }
  //   else
  //   {
  //     this.loginOrLogout = 'Login';
  //   }
  

  // onProductSearchCicked()
  // {
  //   this._router.navigate(['/display-all-products',this.keyword]);
  // }

  // loginUser()
  // {
  //   this._router.navigate(['/user-login']);
  // }

  // logoutUser()
  // {
  //   alert('User Logged Out');
  //   sessionStorage.setItem('user',null);
  //   this.cQty = null;
  //   this.uId = null;
  //   this.ngOnInit();
  //   this._router.navigate(['customerLogin']);
  // }

  // showMyCart()
  // {
  //   if(parseInt(sessionStorage.getItem('user'))>0)
  //   {
  //     this._router.navigate(['CustomerCart']);
  //   }
  //   else
  //   {
  //     alert("Not Logged In");
  //   }
  // }

}
