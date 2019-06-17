/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IOrderDAO;
import aplicacion.modelo.dominio.order.Order;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Lilia Said
 */
public class OrderDAOImp implements Serializable, IOrderDAO {

    @Override
    public void create(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Order getOrderById(int orderId) {
        Session session = null;
        Order order = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            order = (Order) session.load(Order.class, orderId);
            Hibernate.initialize(order);
        } catch (Exception e) {
            // si se produce un error
            // puedo obtener informacion con 
            // e.getMessage() que retorna un string
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return order;
    }

    @Override
    public List<Order> getOrderList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Order.class);
        List<Order> orderList = criteria.list();
        session.close();
        return orderList;
    }

}
