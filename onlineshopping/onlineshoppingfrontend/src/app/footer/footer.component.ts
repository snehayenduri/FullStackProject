import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  uId: number=0;
  constructor
  (
    private router : Router
  ) { }

  ngOnInit(): void 
  {
   // this.uId = parseInt(localStorage.getItem('customerId'));
  }
  // adminLogin()
  // {
  //   if(this.uId>0)
  //   {
  //     alert("User cannot Login as Admin");
  //   }
  //   else
  //   {
  //     this._router.navigate(['adminLogin']);
    

}
