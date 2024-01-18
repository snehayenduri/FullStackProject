import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from 'src/app/customer/Products';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-retailer-product',
  templateUrl: './retailer-product.component.html',
  styleUrls: ['./retailer-product.component.css']
})
export class RetailerProductComponent implements OnInit {

  products: Products[];
  deleteProduct: Products;
  token:number;

  constructor(private router: Router, private retailerService: RetailerService) { 
    this.token=Number(localStorage.getItem("retailerId"));

    this.retailerService.showMyProducts(this.token).subscribe((res) => {this.products=res});

  }

  ngOnInit(): void {
  }

  update(productId: number) {
    localStorage.setItem("updateProductId", JSON.stringify(productId));
    this.router.navigate(['retailerProduct/updateProduct']);

  }


  delete(productId: number) {
    this.retailerService.deleteProduct(productId).
      subscribe(res => { this.deleteProduct = res });
    // this.router.navigate(['retailerProduct']);
    alert("Product Deleted!")
    window.location.reload();
  }

  addProduct(){
    this.router.navigate(['addProduct']);
  }

}
