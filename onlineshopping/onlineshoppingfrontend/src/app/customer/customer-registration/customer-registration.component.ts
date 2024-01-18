import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {

  registerForm: any;
  customerRegistered: any;
  registeredMsg: string="";
  constructor(private customerService: CustomerService,
    private router: Router,
    private formBuilder: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
    this.registeredMsg = "";
  }
  createForm() {
    this.registerForm = this.formBuilder.group({
      customerName:new FormControl('',[Validators.required,Validators.maxLength(10)]),
      password:new FormControl('',[Validators.required, Validators.minLength(5), Validators.pattern("^[a-zA-Z_@0-9]+$"), Validators.maxLength(15)]),
      emailAddres:new FormControl('',[Validators.required, Validators.pattern("^[a-z0-9.]+[@]{1}[a-z]+[.]{1}[a-z]+$"), Validators.maxLength(15)]),
      mobileNumber: new FormControl('',[Validators.required,  Validators.pattern("^[6789]{1}[0-9]{9}$")]),
      doorNo:new FormControl(''),
      street:new FormControl(''),
      city:new FormControl(''),
      state:new FormControl(''),
      country:new FormControl(''),
      pincode:new FormControl('', [Validators.required])
    });  
  }

  
  get customerName() {
    return this.registerForm.get('customerName'); 
  } 
  get mobileNumber() {
    return this.registerForm.get('mobileNumber'); 
  } 
  get emailAddres() {
    return this.registerForm.get('emailAddres'); 
  } 
  get doorNo() {
    return this.registerForm.get('doorNo'); 
  }
  get street() {
    return this.registerForm.get('street'); 
  }
  get city() {
    return this.registerForm.get('city'); 
  }
  get state() {
    return this.registerForm.get('state'); 
  }
  get country() {
    return this.registerForm.get('country'); 
  }
  get pincode() {
    return this.registerForm.get('pincode'); 
  }
  get password() {
    return this.registerForm.get('password'); 
  }
  login(): void {
    this.router.navigate(['customerLogin']);
  }
  register(): void {
    this.registeredMsg = "";
    this.customerService.register(this.registerForm.value).
      subscribe(res => { this.customerRegistered = res });
      {
      this.registeredMsg = "Smart-Kart Welcomes You!\nThis is your Customer Id : " + this.customerRegistered.customerId + "\nUse above Id for future purchasal login ";
      alert(this.registeredMsg);
      this.router.navigate(['customerLogin']);
      }
    
  }

}
