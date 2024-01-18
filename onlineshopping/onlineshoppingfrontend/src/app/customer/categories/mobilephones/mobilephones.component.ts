import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../../Products';

@Component({
  selector: 'app-mobilephones',
  templateUrl: './mobilephones.component.html',
  styleUrls: ['./mobilephones.component.css']
})
export class MobilephonesComponent implements OnInit {

  mobilesList:Products[]=[];

  msg:string="";
  userId:string;
  constructor(private productService:CustomerService) { }

  ngOnInit(): void {
    this.loadMobilesList();

  }
  
  loadMobilesList()
  {
    this.productService.getMobilesList().subscribe(
      data=>
      {this.mobilesList=data;
      console.log("mobiles-list "+this.mobilesList)
      }
    )
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
