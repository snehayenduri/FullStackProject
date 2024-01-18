import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from '../customer/Products';
import { Retailer } from '../Retailer';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private tempUrl =  'http://localhost:8084/hr/';
  private baseUrl =   'http://localhost:8084/hr/';
  constructor(private http : HttpClient) { }


  addNewRetailer(newRetailer:Retailer) : Observable<Retailer>
  {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/admin/addRetailer';
    return this.http.post<Retailer>(this.baseUrl, newRetailer);
  }

  showAllRetailers() : Observable<Retailer[]>
  {
    this.baseUrl = this.tempUrl;
    this.baseUrl += 'admin/showAllRetailers';
    return this.http.get<Retailer[]>(this.baseUrl);
  }

  deleteRetailerById(rid : number) : Observable<Retailer> 
  {//eno is copied here to empNo
    this.baseUrl = this.tempUrl;
    this.baseUrl += 'admin/deleteRetailer/' + rid;
    return this.http.get<Retailer>(this.baseUrl);
  }

  updateRetailer(newRetailer:Retailer) : Observable<Retailer>
  {
      this.baseUrl = this.tempUrl;
      this.baseUrl += 'admin/addRetailer';
      return this.http.post<Retailer>(this.baseUrl,newRetailer);
  }

  getProductById(id : number) : Observable<Products>
  {
    this.baseUrl = this.tempUrl;
    this.baseUrl += 'getProductById/' + id;
    return this.http.get<Products>(this.baseUrl);
  }

  showAllProducts() : Observable<Products[]>
  {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/admin/getproducts';
    return this.http.get<Products[]>(this.baseUrl);
  }

}
