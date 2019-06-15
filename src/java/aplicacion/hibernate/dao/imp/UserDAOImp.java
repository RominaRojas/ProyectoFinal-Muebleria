/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IUserDAO;
import aplicacion.modelo.dominio.user.User;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author Lilia Said
 */
public class UserDAOImp implements Serializable, IUserDAO {

    @Override
    public void create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

}
