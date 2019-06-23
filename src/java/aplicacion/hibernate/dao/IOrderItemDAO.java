/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.order.OrderItem;
import java.util.List;

/**
 *
 * @author Lilia Said
 */
public interface IOrderItemDAO {

    void create(OrderItem orderItem);

    void update(OrderItem orderItem);

    void delete(OrderItem orderItem);

    OrderItem getOrderItemById(int orderItemId);

    List<OrderItem> getOrderItemList();
    
    List<OrderItem> getOrderItemByOrderId(int orderId);
}
