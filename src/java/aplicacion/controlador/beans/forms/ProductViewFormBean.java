/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ProductBean;
import aplicacion.modelo.dominio.product.Product;
import aplicacion.modelo.dominio.user.User;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author LILI
 */
@ManagedBean
@RequestScoped
public class ProductViewFormBean implements Serializable {

    @ManagedProperty(value = "#{productBean}")
    private ProductBean productBean;
    private Product product = null;
    private int productId;

    private int productQty = 1;

    /**
     * Creates a new instance of ProductViewFormBean
     */
    public ProductViewFormBean() {
    }

    private void redirectToHome() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
        }
    }

    /**
     * Si el usuario esta logueado redirige al checkout de lo 
     * contrario al login.
     * @return 
     */
    public String buyProduct() {
        String redirection = "login?faces-redirect=true";

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        User user = (User) externalContext.getSessionMap().get("user");
        if (user != null) {
            redirection = "checkout?productid="
                    + Integer.toString(productId)
                    + "&productqty="
                    + Integer.toString(productQty)
                    + "&faces-redirect=true";
        }
        
        return redirection;
    }

    /**
     * Nos devuelve un producto.
     * si el producto es igual a nulo, cargará el producto segun id en url.
     * @return 
     */
    public Product getProduct() {
        if (product == null) {
            Map<String, String> params = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();

            if (params.get("id") != null) {
                productId = Integer.parseInt(params.get("id"));
            }

            product = productBean.getProductById(productId);
        }

        return product;
    }

    /**
     * Segun id se retorna la direccion de la imagen.
     * @param productId
     * @return 
     */
    public String getProductImage(int productId){
        return "/Imagen/Catalogo/"+Integer.toString(productId)+".jpg";
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
