import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../../Products';

@Component({
  selector: 'app-sortbyprice-lowtohigh',
  templateUrl: './sortbyprice-lowtohigh.component.html',
  styleUrls: ['./sortbyprice-lowtohigh.component.css']
})
export class SortbypriceLowtohighComponent implements OnInit {

  sortedbyProductPrice:Products[]=[];
  msg:string="";
  userId:string;
  constructor(private productService:CustomerService) { }

  ngOnInit(): void {
    this.loadSortedList();

  }
  
  loadSortedList()
  {
    this.productService.getSortedPriceListLowToHigh().subscribe(
      data=>
      {this.sortedbyProductPrice=data;
      console.log("sorted-list "+this.sortedbyProductPrice)
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
