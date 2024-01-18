import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../customer/Category';
import { Products } from '../customer/Products';
import { Retailer } from '../Retailer';

@Injectable({
  providedIn: 'root'
})
export class RetailerService {

  private baseUrl = "http://localhost:8084/retailer";
  private tempUrl = "http://localhost:8084/retailer";


  constructor(private http : HttpClient) { }

  login(retailerId:number){
    console.log(retailerId);

    console.log("In services : "+ (this.http.get<Retailer>(this.baseUrl+"/getRetailer/"+retailerId)));
    return this.http.get<Retailer>(this.baseUrl+"/getRetailer/"+retailerId);
  }

  getCategory(categoryId:number)
  {
    console.log(categoryId);

    console.log("In services : "+ (this.http.get<Category>(this.baseUrl+"/getCategory/"+categoryId)));
    return this.http.get<Category>(this.baseUrl+"/getCategory/"+categoryId);
  }
  addProduct(product :Products){
    console.log('In service');
       return this.http.post(this.baseUrl+"/addRetailerProduct",
         JSON.stringify(product),
       {
          headers:
             { 'Content-Type': 'application/json' }
        });
  }

  showMyProducts(retailerId:number){
    console.log('In service' + this.http.get<Products[]>(this.baseUrl+"/getRetailerProductsById/"+retailerId));
    return this.http.get<Products[]>(this.baseUrl+"/getRetailerProductsById/"+retailerId);
  }

  updateProduct(product : Products){
    console.log('In service');
      return this.http.post<Products>(this.baseUrl+"/updateProduct",
        JSON.stringify(product),
        {
          headers:
            { 'Content-Type': 'application/json' }
        });
  }

  getProductById(productId : number):Observable<Products>{
    console.log('In service');
    console.log(productId);
    console.log(this.http.get<Products>("http://localhost:8084/customer/products/"+productId));
    return this.http.get<Products>("http://localhost:8084/customer/products/"+productId);
  }

  deleteProduct(productId : number){
    console.log('In service');
    return this.http.delete<Products>(this.baseUrl+"/deleteProduct/"+productId);
  }


  addNewRetailer(newRetailer:Retailer) : Observable<Retailer>
  {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/admin/addRetailer';
    return this.http.post<Retailer>(this.baseUrl, newRetailer);
  }

  showAllRetailers() : Observable<Retailer[]>
  {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/admin/showAllRetailers';
    return this.http.get<Retailer[]>(this.baseUrl);
  }

  deleteRetailerById(rid : number) : Observable<Retailer> 
  {//eno is copied here to empNo
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/admin/deleteRetailer/' + rid;
    return this.http.get<Retailer>(this.baseUrl);
  }

  updateRetailer(newRetailer:Retailer) : Observable<Retailer>
  {
      this.baseUrl = this.tempUrl;
      this.baseUrl += '/admin/addRetailer';
      return this.http.post<Retailer>(this.baseUrl,newRetailer);
  }

  // getProductById(id : number) : Observable<Product>
  // {
  //   this.baseUrl = this.tempUrl;
  //   this.baseUrl += 'getProductById/' + id;
  //   return this.http.get<Product>(this.baseUrl);
  // }

  showAllProducts() : Observable<Products[]>
  {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/admin/getproducts';
    return this.http.get<Products[]>(this.baseUrl);
  }
}
