import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-retailer-header',
  templateUrl: './retailer-header.component.html',
  styleUrls: ['./retailer-header.component.css']
})
export class RetailerHeaderComponent implements OnInit {

  token:number;
  constructor(private router: Router) {
    this.token=Number(localStorage.getItem("retailerId"));
    if(this.token==0){
      this.router.navigate(['retailerLogin']);
    }

   }

  ngOnInit(): void {
  }

  home(){
    this.router.navigate(['retailerProduct']);
  }
  logout(){
    localStorage.removeItem("retailerId");
    this.router.navigate(['retailerLogin']);
  }

}
