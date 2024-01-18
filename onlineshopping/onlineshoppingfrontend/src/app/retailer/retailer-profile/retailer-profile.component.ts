import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Retailer } from 'src/app/Retailer';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-retailer-profile',
  templateUrl: './retailer-profile.component.html',
  styleUrls: ['./retailer-profile.component.css']
})
export class RetailerProfileComponent implements OnInit {

  retailer:Retailer
  retailerId:number;
  constructor(private router: Router, private retailerService: RetailerService) { }

  ngOnInit(): void {
    this.retailerId=Number(localStorage.getItem("retailerId"));
    this.retailerService.login(this.retailerId).
    subscribe((res:Retailer) => {this.retailer=res});
  }

  close(){
    this.router.navigate(['retailerProduct']);
  }

}
