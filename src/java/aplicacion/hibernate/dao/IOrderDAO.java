/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.order.Order;
import java.util.List;

/**
 *
 * @author Lilia Said
 */
public interface IOrderDAO {

    void create(Order order);

    void update(Order order);

    void delete(Order order);

    Order getOrderById(int orderId);

    List<Order> getOrderList();
    
    int getLastOrderNumber();
    
    List<Order> getOrderListByUserId(int userId);
}
