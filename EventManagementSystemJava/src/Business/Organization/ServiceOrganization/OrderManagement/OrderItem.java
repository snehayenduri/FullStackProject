/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization.ServiceOrganization.OrderManagement;

import Business.Organization.ServiceOrganization.ProductManagement.Product;

/**
 *
 * @author nitin
 */
public class OrderItem {
    int orderId;
    Product selectedProduct;
    int quantity;
    public OrderItem(int orderId, Product product, int quantity){
        this.selectedProduct = product;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    
    
    
}
