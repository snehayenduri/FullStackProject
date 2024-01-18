import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from '../Customer';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {

  customerId:number;
  customerDetails:Customer;

  constructor(private customerService: CustomerService, private router: Router) {
    this.customerId=Number(localStorage.getItem("customerId"));
    this.customerService.login(this.customerId).
    subscribe((res:Customer) => {this.customerDetails=res});

   }

  ngOnInit(): void {
  }

  close(){
    this.router.navigate(['customerHome']);
  }


}
