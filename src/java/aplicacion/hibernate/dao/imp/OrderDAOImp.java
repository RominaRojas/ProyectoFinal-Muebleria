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
import org.hibernate.Session;

/**
 *
 * @author LILI-PC
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

}
