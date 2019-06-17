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
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

    @Override
    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getUserById(int userId) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.load(User.class, userId);
            Hibernate.initialize(user);
        } catch (Exception e) {
            // si se produce un error
            // puedo obtener informacion con 
            // e.getMessage() que retorna un string
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            user = (User) criteria.add(Restrictions.eq("email", email))
                    .uniqueResult();
        } catch (Exception e) {
            // si se produce un error
            // puedo obtener informacion con 
            // e.getMessage() que retorna un string
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public List<User> getUserList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();
        session.close();
        return userList;
    }

    @Override
    public User verifyCredentials(String email, String password) {
        User user = getUserByEmail(email);

        // Si la contraseña es incorrecta
        if (user != null && user.getPassword().equals(password) == false) {
            // asigno al usuario null
            user = null;
        }

        return user;
    }

}
