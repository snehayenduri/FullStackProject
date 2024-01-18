import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Retailer } from 'src/app/Retailer';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-admin-update',
  templateUrl: './admin-update.component.html',
  styleUrls: ['./admin-update.component.css']
})
export class AdminUpdateComponent implements OnInit {

  upRetailer = new  Retailer();
  exform:FormGroup;


  constructor
  (
    private _router : Router,
    private _retailerService : RetailerService,
    private formBuilder: FormBuilder
  ) { }

  
  ngOnInit(): void {
    if(sessionStorage.getItem('admin')=="null")
    {
      alert("Admin Not Logged In");
      this._router.navigate(['admin-login']);
    }
    this.exform = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(5)]],
      mobileNumber: ['', [Validators.required, Validators.pattern("[0-9]{10}")]],
      name: ['', [Validators.required, Validators.minLength(4)]]
  });
  }
  updateRetailer()
  {

    if(this.upRetailer==null){
      console.log("Empty Object");
    }
    
    this._retailerService.updateRetailer(this.upRetailer)
    .subscribe(data=>
      {
        if(data==null)
        {
          alert("Retailer not exists");
        }
        else
        {
          alert("Updated Successfully");
        }
      })
  }


}
