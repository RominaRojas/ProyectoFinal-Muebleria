
package aplicacion.modelo.dominio.product;

import java.io.Serializable;

public class Product implements Serializable{
    private int id;
    private int productId;
    private int stock;
    private double price;
    private String name;
    private String description;
    private int categoryId;

    public Product() {
    
    }

    public Product(int id, Integer productId, int stock, double price, String name, String description, int categoryId) {
        this.id = id;
        this.productId = productId;
        this.stock = stock;
        this.price = price;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}