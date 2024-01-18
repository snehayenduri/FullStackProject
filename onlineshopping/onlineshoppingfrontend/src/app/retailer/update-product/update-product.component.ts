import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Products } from 'src/app/customer/Products';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  token : number;
  product:Products;
  returnProduct:any;
  updateProductForm: any;

  constructor(private retailerService : RetailerService, private formBuilder: FormBuilder, private router: Router) {
    this.token=Number(localStorage.getItem('updateProductId'));
    console.log(this.token);
    retailerService.getProductById(this.token).subscribe(res => {this.product=res});
    console.log("update constructor"+this.product);
    this.createForm();
   }

  ngOnInit(): void {
  }

  createForm() {
    this.updateProductForm = this.formBuilder.group({
      productId:new FormControl({value:this.product.productId, disabled: true}), //this.product.productId),
      productName:new FormControl({value:this.product.productName, disabled: true}),//this.product.productName),
      productBrand:new FormControl({value:this.product.productBrand, disabled: true}),//this.product.productBrand),
      categoryId:new FormControl({value:this.product.category.categoryId, disabled: true}),//this.product.categoryId),
      retailerId:new FormControl({value:this.product.retailer.retailerId, disabled: true}),//this.product.retailerId),
      productImage:new FormControl({value:this.product.productImage, disabled: true}),//this.product.productImage),
      quantity:new FormControl({value:this.product.quantity, disabled:false}),//this.product.quantity),
      productCost:new FormControl({value:this.product.productCost, disabled:false}),//this.product.productCost)
    });  
  }

  
  get productId() {
    return this.updateProductForm.get('productId'); 
  } 
  get productName() {
    return this.updateProductForm.get('productName'); 
  } 
  get productBrand() {
    return this.updateProductForm.get('productBrand'); 
  } 
  get categoryId() {
    return this.updateProductForm.get('categoryId'); 
  }
  get retailerId() {
    return this.updateProductForm.get('retailerId'); 
  }
  get productImage() {
    return this.updateProductForm.get('productImage'); 
  }
  get quantity() {
    return this.updateProductForm.get('quantity'); 
  }
  get productCost() {
    return this.updateProductForm.get('productCost'); 
  } 

  update(){
    this.retailerService.updateProduct(this.updateProductForm.value).
      subscribe(res => { this.returnProduct = res });
    if(this.returnProduct!=null){
      alert("Product with id : "+this.returnProduct.productId+"Updated");
    }
  }
  return(){
    this.router.navigate(['retailerHome/retailerProduct']);
  }

}
