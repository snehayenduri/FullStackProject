import { Retailer } from "../Retailer";
import { Category } from "./Category";

export class Products{

    productId:number=0;
    productName:string="";
    productCost:number=0;
    productImage:string="";
    productBrand:string="";
    quantity:number=0;
    category:Category;
    retailer:Retailer;
    constructor(productName:string,productCost:number,productImage:string,productBrand:string,quantity:number,category:Category,retailer:Retailer){
        this.productName=productName;
        this.productCost=productCost;
        this.productImage=productImage;
        this.productBrand=productBrand;
        this.quantity=quantity;
        this.category=category;
        this.retailer=retailer;

    }

}