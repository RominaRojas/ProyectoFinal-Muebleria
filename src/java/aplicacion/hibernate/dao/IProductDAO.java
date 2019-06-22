/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.product.Product;
import java.util.List;

/**
 *
 * @author Lilia Said
 */
public interface IProductDAO {

    void create(Product product);

    void update(Product product);

    void delete(Product product);

    Product getProductById(int productId);

    List<Product> getProductList();
    
    List<Product> getProductListByCategoryId(int categoryId);
}
