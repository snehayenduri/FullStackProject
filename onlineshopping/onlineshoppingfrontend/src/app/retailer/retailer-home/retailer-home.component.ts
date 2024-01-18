import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-retailer-home',
  templateUrl: './retailer-home.component.html',
  styleUrls: ['./retailer-home.component.css']
})
export class RetailerHomeComponent implements OnInit {

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
    this.router.navigate(['retailerHome']);
  }
  logout(){
    localStorage.removeItem("retailerId");
    this.router.navigate(['retailerLogin']);
  }

}
