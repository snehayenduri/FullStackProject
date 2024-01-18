import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../customer/Cart';
import { Customer } from '../customer/Customer';
import { Products } from '../customer/Products';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private tempUrl =  'http://localhost:8084/customer';
  private baseUrl =   'http://localhost:8084/customer';

  constructor(private http : HttpClient) { }



  ///////////////////////////////////////////////////////////////////////////////////////////////sneha part

  login(customerId:number) {
    console.log("In services : "+ (this.http.get<Customer>(this.baseUrl+"/getCustomer/"+customerId)));
    return this.http.get<Customer>(this.baseUrl+"/getCustomer/"+customerId);
  }

  register(customer: Customer){
     console.log('In service')
      return this.http.post(this.baseUrl+"/addCustomer",
        JSON.stringify(customer),
        {
          headers:
            { 'Content-Type': 'application/json' }
        });
  }


  /////////////////////////////////////////////////////////////////////////////narmada part

  public getProductList()
    {
      console.log(this.http.get<Products[]>(this.baseUrl+'/allProducts'))
      return(this.http.get<Products[]>(this.baseUrl+'/allProducts'))
    }

    public getMenClothesList()
    {

      console.log(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/Men clothes'))
      return(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/Men clothes'))
    }

    public getWomenClothesList()
    {

      console.log(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/Women clothes'))
      return(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/Women clothes'))
    }

    public getMobilesList()
    {

      console.log(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/Mobiles'))
      return(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/Mobiles'))
    }

    public getTelevisionList()
    {

      console.log(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/TV'))
      return(this.http.get<Products[]>(this.baseUrl+'/products/byCategory/TV'))
    }

    public getProductByName(productName:string){

      console.log(this.http.get<Products[]>(this.baseUrl+'/products/byName/'+productName));
      return this.http.get<Products[]>(this.baseUrl+'/products/byName/'+productName);
  
    }

    public getSortedNameList()
    {
      console.log(this.http.get<Products[]>(this.baseUrl+'/products/sortByName'))
      return(this.http.get<Products[]>(this.baseUrl+'/products/sortByName'))
    }

    public getSortedPriceListLowToHigh()
    {
      console.log(this.http.get<Products[]>(this.baseUrl+'/products/sortByCost/lowToHigh'))
      return(this.http.get<Products[]>(this.baseUrl+'/products/sortByCost/lowToHigh'))
    }

    public getSortedPriceListHighToLow()
    {
      console.log(this.http.get<Products[]>(this.baseUrl+'/products/sortByCost/highToLow'))
      return(this.http.get<Products[]>(this.baseUrl+'/products/sortByCost/highToLow'))
    }


    



  //////////////////////////////////////////////////////////////anish part
  getMyCart(uId :number) : Observable<Cart[]>
  {
    
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/cart/getMyCart/' + uId;
    console.log(this.http.get<Cart[]>(this.baseUrl));
    return this.http.get<Cart[]>(this.baseUrl);
  }


  updateMyCart(cartId: string, addOrMinus: string) {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/cart/updateMyCart/' + cartId;
    if (addOrMinus === '1') {
      this.baseUrl += '/' + '1';
      return this.http.get(this.baseUrl, { responseType: 'text' });
    } else {
      this.baseUrl += '/' + '0';
      return this.http.get(this.baseUrl, { responseType: 'text' });
    }
  }

  deleteMyCart(cId:number) {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/cart/deleteMyCart/' + cId;
    return this.http.delete(this.baseUrl, { responseType: 'text' });
  }


  addToMyCart(customerId: number, productId: number) {
    this.baseUrl = this.tempUrl;
    this.baseUrl += '/cart/addToMyCart/' + customerId + '/' + productId;
    return this.http.get(this.baseUrl, { responseType: 'text' });
  }
}
