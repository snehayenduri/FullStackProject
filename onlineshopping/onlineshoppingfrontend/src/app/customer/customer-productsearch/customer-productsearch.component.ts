import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../Products';
import { Product } from './Product';

@Component({
  selector: 'app-customer-productsearch',
  templateUrl: './customer-productsearch.component.html',
  styleUrls: ['./customer-productsearch.component.css']
})
export class CustomerProductsearchComponent implements OnInit {

  productDetail:Product[];
  productName="";
  msg:string="";
  userId:string;

  constructor(private productService: CustomerService) { }

  ngOnInit(): void {
    this.productName=String(localStorage.getItem('searchProductName'));
    if(this.productName!=null)
    {
      this.productService.getProductByName(this.productName).subscribe(
        response=>{this.productDetail=response}
      )
    }
    

  }

  // onSearch(){
  //   this.productService.getProductByName(this.productName).subscribe(
  //     response=>{this.productDetail=response}
  //   )
  //   console.log(this.productDetail);
  // }

  addToMyCart(productID: number) {
    let cId=Number(localStorage.getItem('customerId'))
    this.productService.addToMyCart(cId, productID).subscribe((data: string) => {
    this.msg=data;
    console.log(this.msg);
    console.log(this.userId)
    console.log(productID)
    });
  }

}
