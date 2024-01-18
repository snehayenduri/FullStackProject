import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Retailer } from 'src/app/Retailer';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-admin-retailer',
  templateUrl: './admin-retailer.component.html',
  styleUrls: ['./admin-retailer.component.css']
})
export class AdminRetailerComponent implements OnInit {

  retailers : Retailer[] = [];
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
      this._retailerService.showAllRetailers()
      .subscribe(data=>
        {
          this.retailers = data;
        });
    }
  }
xdata:Retailer;
  deleteRetailer(retailerId: number)
  {
  console.log('emp number to delete '+retailerId);
  this._retailerService.deleteRetailerById(retailerId).
  subscribe((data: Retailer) =>
  {
    this.xdata=data;
   console.log(this.xdata);
   alert("Retailer Deleted");

   window.location.reload();

  });

}
}
