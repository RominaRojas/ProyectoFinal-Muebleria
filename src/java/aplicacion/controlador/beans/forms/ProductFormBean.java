/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ProductBean;
import aplicacion.modelo.dominio.product.Product;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author LILI
 */
@ManagedBean
@RequestScoped
public class ProductFormBean implements Serializable {
        
    @ManagedProperty(value = "#{productBean}")
    private ProductBean productBean;
    private List<Product> productList;

    /**
     * Creates a new instance of ProductFormBean
     */
    public ProductFormBean() {
    }
    
    @PostConstruct
    public void init() {
        productList = productBean.getProductList();
    }
    
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }
   
    public void filterByCategoryId(int categoryId){
        productList = productBean.getProductListByCategoryId(categoryId);        
    }

    public String itemClick(int productId){
        return "product-view?id="+Integer.toString(productId)+"&faces-redirect=true";
    }
    
}
