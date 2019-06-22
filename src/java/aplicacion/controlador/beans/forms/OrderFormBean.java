/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.OrderBean;
import aplicacion.controlador.beans.ProductBean;
import aplicacion.modelo.dominio.order.Order;
import aplicacion.modelo.dominio.order.OrderItem;
import aplicacion.modelo.dominio.order.OrderStatus;
import aplicacion.modelo.dominio.product.Product;
import aplicacion.modelo.dominio.user.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class OrderFormBean implements Serializable {

    @ManagedProperty(value = "#{orderBean}")
    private OrderBean orderBean;
    @ManagedProperty(value = "#{productBean}")
    private ProductBean productBean;

    private Product product;
    private int productQty = 0;
    private int productId;

    /**
     * Creates a new instance of LoginFormBean
     */
    public OrderFormBean() {
    }

    public String buyProduct() {
        String result = "";

        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        if (user != null) {
            Order order = new Order();
            order.addItem(new OrderItem(getProduct(), getProductQty()));
            order.setState(OrderStatus.pending);
            order.setUser(user);
            order.setOrderNumber(10000000);
            order.setCreatedAt(Calendar.getInstance());

            orderBean.create(order);
        } else {
            result = "login?faces-redirect=true";
        }

        return result;
    }

    public Product getProduct() {
        if (product == null) {
            Map<String, String> params = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();

            if (params.get("productid") != null) {
                productId = Integer.parseInt(params.get("productid"));
            }

            product = productBean.getProductById(productId);
        }
        return product;
    }

    public int getProductQty() {
        if (productQty == 0) {
            Map<String, String> params = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();

            productQty = 1;
            if (params.get("productqty") != null) {
                productQty = Integer.parseInt(params.get("productqty"));
            }
        }
        return productQty;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
