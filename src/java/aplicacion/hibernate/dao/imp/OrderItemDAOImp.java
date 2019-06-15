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
import org.hibernate.Session;

/**
 *
 * @author LILI-PC
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

}
