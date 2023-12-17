/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.ServiceOrganization.ProductManagement;

import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class ProductCatalog {
    ArrayList<Product> productList;
    public ProductCatalog(){
       productList = new ArrayList<>();
    }
    public Product addNewProduct(String name, float price){
        if(searchProduct(name)==null){
            Product newProduct = new Product(name, price);
        productList.add(newProduct);
        return newProduct;
        }
        return null;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public Product searchProduct(String name){
        for(Product product: productList){
            if(product.getName().equals(name))
                return product;
        }
        return null;
    }
}
