import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../../Products';

@Component({
  selector: 'app-sortbyprice-hightolow',
  templateUrl: './sortbyprice-hightolow.component.html',
  styleUrls: ['./sortbyprice-hightolow.component.css']
})
export class SortbypriceHightolowComponent implements OnInit {

  sortedbyProductPriceHTL:Products[]=[];

  msg:string="";
  userId:string;
  constructor(private productService:CustomerService) { }

  ngOnInit(): void {
    this.loadSortedList();

  }
  
  loadSortedList()
  {
    this.productService.getSortedPriceListHighToLow().subscribe(
      data=>
      {this.sortedbyProductPriceHTL=data;
      console.log("sorted-list "+this.sortedbyProductPriceHTL)
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
