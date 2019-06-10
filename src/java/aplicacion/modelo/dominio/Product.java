
package aplicacion.modelo.dominio;

public class Product {
    private int id;
    private Integer productId;
    private int stock;
    private double price;
    private String name;
    private String description;
    private Integer categoriaId;

    public Product() {
    
    }

    public Product(int id, Integer productId, int stock, double price, String name, String description, Integer categoriaId) {
        this.id = id;
        this.productId = productId;
        this.stock = stock;
        this.price = price;
        this.name = name;
        this.description = description;
        this.categoriaId = categoriaId;
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

    public void setProductId(Integer productId) {
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

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}
