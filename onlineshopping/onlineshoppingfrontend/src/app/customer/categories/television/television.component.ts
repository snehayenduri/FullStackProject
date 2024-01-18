import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../../Products';

@Component({
  selector: 'app-television',
  templateUrl: './television.component.html',
  styleUrls: ['./television.component.css']
})
export class TelevisionComponent implements OnInit {

  televisionList:Products[]=[];
  msg:string="";
  userId:string;
  constructor(private productService:CustomerService) { }

  ngOnInit(): void {
    this.loadTelevisionList();

  }
  
  loadTelevisionList()
  {
    this.productService.getTelevisionList().subscribe(
      data=>
      {this.televisionList=data;
      console.log("television-list "+this.televisionList)
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
