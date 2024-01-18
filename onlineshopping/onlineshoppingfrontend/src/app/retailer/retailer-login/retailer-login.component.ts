import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Retailer } from 'src/app/Retailer';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-retailer-login',
  templateUrl: './retailer-login.component.html',
  styleUrls: ['./retailer-login.component.css']
})
export class RetailerLoginComponent implements OnInit {

  loginForm: FormGroup;
  error = false;
  retailerDetails:Retailer;
  retailerId:number;
  password:string;
  constructor(private retailerService: RetailerService,
    private router: Router,
    private formBuilder: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
    this.retailerId=Number(localStorage.getItem("retailerId"));
    if(this.retailerId!=0){
      this.router.navigate(['retailerProduct']);
    }
  }
  createForm() {
    this.loginForm = this.formBuilder.group({
      retailerId: '',
      password: ''
    });
  }

  login(): void {
    this.retailerId=this.loginForm.value.retailerId;
    this.password=this.loginForm.value.password;
    this.retailerService.login(this.retailerId).subscribe((res:Retailer) => {this.retailerDetails=res});
    if(this.password==this.retailerDetails.password){
    localStorage.setItem('retailerId', JSON.stringify(this.retailerDetails.retailerId));
    this.router.navigate(['retailerProduct']);
    }
   }


}
