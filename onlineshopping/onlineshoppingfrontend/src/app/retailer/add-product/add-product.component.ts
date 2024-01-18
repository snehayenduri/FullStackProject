import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/customer/Category';
import { Products } from 'src/app/customer/Products';
import { Retailer } from 'src/app/Retailer';
import { RetailerService } from 'src/app/services/retailer.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  addProductForm: any;
  returnProduct:any;
  retailerIdToken:number;
  product:Products;
  retailer:Retailer;
  category:Category;

  productName1:string="";
  productCost1:number=0;
  productImage1:string="";
  productBrand1:string="";
  quantity1:number=0;


  constructor(private retailerService : RetailerService, private formBuilder: FormBuilder, private router: Router) { 
    
    this.retailerIdToken=Number(localStorage.getItem('retailerId'));

    this.createForm();

  }

  ngOnInit(): void {
  }

  createForm() {
    this.addProductForm = this.formBuilder.group({
      productName:new FormControl(''),//this.product.productName),
      productBrand:new FormControl(''),//this.product.productBrand),
      categoryId:new FormControl(''),//this.product.categoryId),
      retailerId:new FormControl({value:this.retailerIdToken,disabled:true}),//this.product.retailerId),
      productImage:new FormControl(''),//this.product.productImage),
      quantity:new FormControl(''),//this.product.quantity),
      productCost:new FormControl(''),//this.product.productCost)
    });  
  }
  get productName() {
    return this.addProductForm.get('productName'); 
  } 
  get productBrand() {
    return this.addProductForm.get('productBrand'); 
  } 
  get categoryId() {
    return this.addProductForm.get('categoryId'); 
  }
  get retailerId() {
    return this.addProductForm.get('retailerId'); 
  }
  get productImage() {
    return this.addProductForm.get('productImage'); 
  }
  get quantity() {
    return this.addProductForm.get('quantity'); 
  }
  get productCost() {
    return this.addProductForm.get('productCost'); 
  } 

   add(){
    //  console.log(this.addProductForm.value.productName);
    this.productName1=this.addProductForm.value.productName;
    this.productBrand1=this.addProductForm.value.productBrand;    
    this.productCost1=this.addProductForm.value.productCost;
    this.quantity1=this.addProductForm.value.quantity;
    this.productImage1=this.addProductForm.value.productImage;
    this.retailerService.login(this.retailerIdToken).subscribe(res=>{this.retailer=res})
    this.retailerService.getCategory(this.addProductForm.value.categoryId).subscribe(res=>{this.category=res})
    
    this.product=new Products(this.productName1,this.productCost1,this.productImage1,this.productBrand1,this.quantity1,this.category,this.retailer)
    
    this.retailerService.addProduct(this.product).
      subscribe(res => { this.returnProduct = res });
     
     if(this.returnProduct!=null){
       this.router.navigate(['retailerProduct'])
    }
   }
  return(){
    this.router.navigate(['retailerHome/retailerProduct']);
  }

}
