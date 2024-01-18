import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import { Customer } from '../Customer';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {

  loginForm: FormGroup;
  error = false;
  customerDetails:Customer;
  customerId:number=0;
  password:string="";
  constructor(private customerService: CustomerService,
    private router: Router,
    private formBuilder: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
    this.error = false;
    this.customerId=Number(localStorage.getItem("customerId"));
    if(this.customerId!=0){
      this.router.navigate(['customerHome']);
    }
  }
  createForm() {
    this.loginForm = this.formBuilder.group({
      customerId: '',
      password: ''
    });
  }

  register():void{
    this.router.navigate(['customerRegister']);
  }

  login(): void {
    this.customerId=this.loginForm.value.customerId;
    this.password=this.loginForm.value.password;

    this.customerService.login(this.customerId).
      subscribe((res:Customer) => {this.customerDetails=res});


        if( this.customerDetails.password==this.password){
        this.error = false;
        localStorage.setItem('customerId', JSON.stringify(this.customerDetails.customerId))
        this.router.navigate(['customerHome']);
        }else{
          this.loginForm.value.customerId='';
          this.loginForm.value.password='';
        this.error = true;
        this.router.navigate(['customerLogin']);
        }
      
    // }else{      
    //   this.loginForm.value.customerId='';
    //   this.loginForm.value.password='';
    //   this.error = true;
    //   this.router.navigate(['customerLogin']);
    // }
  }

}
