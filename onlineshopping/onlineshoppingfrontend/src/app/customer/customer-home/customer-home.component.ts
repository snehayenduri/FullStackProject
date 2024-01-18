import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../Products';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {

  allproductList:Products[]=[];
  msg:string="";
  userId:string;

  constructor(private productService:CustomerService,private activatedRoute:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.loadProductList();
    
  }
  
  loadProductList()
  {
    this.productService.getProductList().subscribe(
      data=>
      {this.allproductList=data;
      console.log("in product-list "+this.allproductList)
      }
    )
  }
  

  sortbyName(){
    this.router.navigate(['/sortbyname'])
  }

  sortbyPriceAsc(){
    this.router.navigate(['/sortbypriceLowToHigh'])
  }

  sortbyPriceDesc(){
    this.router.navigate(['/sortbypriceHighToLow'])
  }

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
