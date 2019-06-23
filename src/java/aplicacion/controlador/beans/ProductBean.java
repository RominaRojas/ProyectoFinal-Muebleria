/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IProductDAO;
import aplicacion.hibernate.dao.imp.CategoryDAOImp;
import aplicacion.hibernate.dao.imp.ProductDAOImp;
import aplicacion.modelo.dominio.product.Product;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sbalgass
 */
@ManagedBean
@RequestScoped
public class ProductBean implements Serializable{

    private IProductDAO iProductDAO;

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
        iProductDAO = new ProductDAOImp();
    }
    
    public List<Product> getProductList(){
        return iProductDAO.getProductList();
    }
    
    public List<Product> getProductListByCategoryId(int categoryId){
        return iProductDAO.getProductListByCategoryId(categoryId);
    }

    public Product getProductById(int productId) {
        return iProductDAO.getProductById(productId);
    }
    
    public void subtractStock(int productId, int quantity) {
        iProductDAO.subtractStock(productId, quantity);
    }
    
}
