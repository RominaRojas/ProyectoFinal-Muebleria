/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IOrderItemDAO;
import aplicacion.hibernate.dao.imp.OrderItemDAOImp;
import aplicacion.modelo.dominio.order.OrderItem;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class OrderItemBean {

    private IOrderItemDAO iOrderItemDAO;

    public OrderItemBean() {
        iOrderItemDAO = new OrderItemDAOImp();
    }

    public void create(OrderItem orderItem) {
        iOrderItemDAO.create(orderItem);
    }

    public List<OrderItem> getOrderItemByOrderId(int orderId){
        return iOrderItemDAO.getOrderItemByOrderId(orderId);
    }
    
}
