import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../../Products';

@Component({
  selector: 'app-women-clothes',
  templateUrl: './women-clothes.component.html',
  styleUrls: ['./women-clothes.component.css']
})
export class WomenClothesComponent implements OnInit {

  womenClothesList:Products[]=[];
  msg:string="";
  userId:string;
  constructor(private productService:CustomerService) { }

  ngOnInit(): void {
    this.loadWomenClothesList();

  }
  
  loadWomenClothesList()
  {
    this.productService.getWomenClothesList().subscribe(
      data=>
      {this.womenClothesList=data;
      console.log("womenClothes-list "+this.womenClothesList)
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
