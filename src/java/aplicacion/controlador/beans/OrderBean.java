/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IOrderDAO;
import aplicacion.hibernate.dao.imp.OrderDAOImp;
import aplicacion.modelo.dominio.order.Order;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class OrderBean {

    private IOrderDAO iOrderDAO;

    public OrderBean() {
        iOrderDAO = new OrderDAOImp();
    }

    public void create(Order order) {
        iOrderDAO.create(order);
    }
    
    public void update(Order order) {
        iOrderDAO.update(order);
    }

    public int getLastOrderNumber() {
        return iOrderDAO.getLastOrderNumber();
    }
    
    public List<Order> getOrderList(){
        return iOrderDAO.getOrderList();
    }

    public IOrderDAO getiOrderDAO() {
        return iOrderDAO;
    }

    public void setiOrderDAO(IOrderDAO iOrderDAO) {
        this.iOrderDAO = iOrderDAO;
    }

    public List<Order> getOrderListByUserId(int userId){
        return iOrderDAO.getOrderListByUserId(userId);
    }
    
    public Order getOrderById(int orderId){
        return iOrderDAO.getOrderById(orderId);
    }
    
    public List<Order> getOrderListWithUser(){
        return iOrderDAO.getOrderListWithUser();
    }
    
}
