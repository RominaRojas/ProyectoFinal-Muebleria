/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio.order;

import aplicacion.modelo.dominio.product.Product;
import java.io.Serializable;

/**
 *
 * @author Lilia Said
 */
public class OrderItem implements Serializable {


    private int id;
    private int quantity;
    private double price;
    private String productName;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity){
        this.quantity = quantity;
        this.productName = product.getName();
        this.price = product.getPrice();
    }
    public OrderItem(int quantity, double price, String productName) {
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
    }
    
    public OrderItem(int id, int quantity, double price, String productName) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
}
