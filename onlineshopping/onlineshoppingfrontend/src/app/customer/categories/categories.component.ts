import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from '../Products';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  constructor(private activatedRoute:ActivatedRoute,private router:Router) {}


  productList1:Products[]=[];

  ngOnInit(): void {
    
  }

  menClothes(){

    this.router.navigate(['/menclothes'])
  }

  womenClothes(){

    this.router.navigate(['/womenclothes'])
  }

  mobiles(){

    this.router.navigate(['/mobiles'])
  }

  television(){

    this.router.navigate(['/television'])
  }

}
