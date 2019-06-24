/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IOrderItemDAO;
import aplicacion.modelo.dominio.order.OrderItem;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lilia Said
 */
public class OrderItemDAOImp implements Serializable, IOrderItemDAO {

    @Override
    public void create(OrderItem orderItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(orderItem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(OrderItem orderItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(orderItem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(OrderItem orderItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(orderItem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public OrderItem getOrderItemById(int orderItemId) {
        Session session = null;
        OrderItem orderItem = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            orderItem = (OrderItem) session.load(OrderItem.class, orderItemId);
            Hibernate.initialize(orderItem);
        } catch (Exception e) {
            // si se produce un error
            // puedo obtener informacion con 
            // e.getMessage() que retorna un string
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return orderItem;
    }

    @Override
    public List<OrderItem> getOrderItemList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(OrderItem.class);
        List<OrderItem> orderItemList = criteria.list();
        session.close();
        return orderItemList;
    }

    /**
     * Obtiene un listado de orderItems segun orderId
     * @param orderId
     * @return 
     */
    @Override
    public List<OrderItem> getOrderItemByOrderId(int orderId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(OrderItem.class);
                
        criteria.add(Restrictions.          
                sqlRestriction("{alias}.order_id = "+Integer.toString(orderId))
        );
        return criteria.list();
    }

}
