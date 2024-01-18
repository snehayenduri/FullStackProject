import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from 'src/app/customer/Products';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-admin-product',
  templateUrl: './admin-product.component.html',
  styleUrls: ['./admin-product.component.css']
})
export class AdminProductComponent implements OnInit {

  products: Products[] = [];
  constructor
  (
    private _router : Router,
    private _retailerService : RetailerService
  ) { }

  ngOnInit(): void
  {
    if(sessionStorage.getItem('admin')=="null")
    {
      alert("Admin Not Logged In");
      this._router.navigate(['admin-login']);
    }
    else
    {
      this._retailerService.showAllProducts()
      .subscribe(data=>
        {
          this.products = data;
        });
    }
  }

}
