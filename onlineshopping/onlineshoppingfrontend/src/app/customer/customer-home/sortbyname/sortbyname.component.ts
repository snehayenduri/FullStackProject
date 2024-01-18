import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../../Products';

@Component({
  selector: 'app-sortbyname',
  templateUrl: './sortbyname.component.html',
  styleUrls: ['./sortbyname.component.css']
})
export class SortbynameComponent implements OnInit {

  sortedbyProductName:Products[]=[];

  msg:string="";
  userId:string;
  constructor(private productService:CustomerService) { }

  ngOnInit(): void {
    this.loadSortedList();

  }
  
  loadSortedList()
  {
    this.productService.getSortedNameList().subscribe(
      data=>
      {this.sortedbyProductName=data;
      console.log("sorted-list "+this.sortedbyProductName)
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
