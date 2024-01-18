import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import { Cart } from '../Cart';

@Component({
  selector: 'app-customer-cart',
  templateUrl: './customer-cart.component.html',
  styleUrls: ['./customer-cart.component.css']
})
export class CustomerCartComponent implements OnInit {

  userCart: Cart[]=[];
  uId:any;
  totalPrice: number = 0;
  buyProductButton: boolean = false;
  pictures: string[]=[];
  cId:number=0;
  msg:string="";

  public static flag:number=0;
  constructor
  (
    private _customerService : CustomerService,
    private _router : Router
  ) { }

  ngOnInit(): void {


    let cId=Number(localStorage.getItem('customerId'))
    this.uId = Number(localStorage.getItem('customerId'));
    if(this.uId==0)
    {
      //alert("User Not Logged In");
      this._router.navigate(['customerLogin']);
    }
    if(CustomerCartComponent.flag==0){

      this._customerService.getMyCart(this.uId)
      .subscribe((data:Cart[])=>
      {
        this.userCart = data;
        if(this.userCart.length==0)
        {
          this.totalPrice = 0;
          this.buyProductButton = true;
          return;
        }
        this.totalPrice = this.userCart[this.userCart.length-1].totalPrice;
      });

    }
      
        
  
    

  }

  addToMyCart(productID: number) {
    //let uId = sessionStorage.getItem('user');
    this._customerService.addToMyCart(this.cId, productID).subscribe((data: string) => {
    this.msg =data;
    console.log(this.msg);
    });
  }

  reloadData()
  {
    this._customerService.getMyCart(this.uId)
    .subscribe((data:Cart[])=>
    {
      this.userCart = data;
      if(this.userCart.length==0)
      {
        this.totalPrice = 0;
        this.buyProductButton = true;
        return;
      }
      this.totalPrice = this.userCart[this.userCart.length-1].totalPrice;
    });
  }

  onAddUpdateClick(cId:number)
  {
    this._customerService.updateMyCart(cId.toString(),'1')
    .subscribe((data:string)=>
    {
      //alert(data);
      this.reloadData();
    });
  }
  onMinusUpdateClick(cId:number)
  {
    this._customerService.updateMyCart(cId.toString(),'0')
    .subscribe((data:string)=>
    {
      //alert(data);
      this.reloadData();
    });
  }

  onDeleteCartProductClick(cartId:number)
  { 
    this._customerService.deleteMyCart(cartId)
    .subscribe((data:string)=>
    {
      this.reloadData();
    })
  }
  
  getTotalValue(pPrice: number,qty: number)
  {
    return pPrice * qty;
  }

  onBuyProductClick(){
    CustomerCartComponent.flag=1;
    this._router.navigate(['placeorder']);


  }

}
