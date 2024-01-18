import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminLogin } from 'src/app/AdminLogin';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  login: AdminLogin;
  id: number;
  password: string;

  constructor
    (private formBuilder: FormBuilder,
    //private _customerService : CartService,
    private _router : Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('admin')=="null")
    {
      alert("Already Logged In");
      this._router.navigate(['home']);
    }
    this.registerForm = this.formBuilder.group({
      id: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(2)]]
  });
  }

  loginUser()
  {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
else{
    
    this.login = new AdminLogin();
    this.login.adminId = this.id;
    this.login.password = this.password;
    if(this.login.adminId==1 && this.login.password=='Shop@123')
    {
      sessionStorage.setItem('id','1');
      this._router.navigate(['admin-retailer']);
    }
    else
    {
      alert('Admin Not Found');
    }}
  }
  // moveToHomePage(id)
  // {
  //   if(id<0)
  //   {
  //     alert('User Not Found');
  //     this.uId$ = null;
  //     return;
  //   }
  //   sessionStorage.setItem('id',id);
  //   this._router.navigate(['home']);
  // }
  get f() { return this.registerForm.controls; }

}
