import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { Products } from '../../Products';

@Component({
  selector: 'app-men-clothes',
  templateUrl: './men-clothes.component.html',
  styleUrls: ['./men-clothes.component.css']
})
export class MenClothesComponent implements OnInit {

  menClothesList:Products[]=[];
  msg:string="";
  userId:string;
  constructor(private productService:CustomerService) { }

  ngOnInit(): void {
    this.loadMenClothesList();

  }
  
  loadMenClothesList()
  {
    this.productService.getMenClothesList().subscribe(
      data=>
      {this.menClothesList=data;
      console.log("menClothes-list "+this.menClothesList)
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
