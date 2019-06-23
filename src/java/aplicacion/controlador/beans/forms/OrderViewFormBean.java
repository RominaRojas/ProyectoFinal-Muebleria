/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.OrderBean;
import aplicacion.controlador.beans.OrderItemBean;
import aplicacion.modelo.dominio.order.Order;
import aplicacion.modelo.dominio.order.OrderItem;
import aplicacion.modelo.dominio.user.User;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
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
public class OrderViewFormBean implements Serializable {

    @ManagedProperty(value = "#{orderItemBean}")
    private OrderItemBean orderItemBean;
    @ManagedProperty(value = "#{orderBean}")
    private OrderBean orderBean;
    private Order order;
    private List<OrderItem> orderItem;

    /**
     * Creates a new instance of LoginFormBean
     */
    public OrderViewFormBean() {
    }

    @PostConstruct
    public void init() {

        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        int orderId = getOrderIdFromUrl();
        
        if (orderId == 0){
            redirectTo("order.xhtml");
        }else if(user == null){
            redirectTo("login.xhtml");
        }else{
            
            orderItem = orderItemBean.getOrderItemByOrderId(orderId);
            order = orderBean.getOrderById(orderId);
        }

    }

    private int getOrderIdFromUrl() {
        int orderIdFromUrl = 0;
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();

        if (params.get("id") != null){
            orderIdFromUrl = Integer.parseInt(params.get("id"));
        }
        return orderIdFromUrl;
    }

    private void redirectTo(String destination) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(destination);
        } catch (IOException ex) {
        }
    }

    public OrderItemBean getOrderItemBean() {
        return orderItemBean;
    }

    public void setOrderItemBean(OrderItemBean orderItemBean) {
        this.orderItemBean = orderItemBean;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }
    
    

}
