/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.ICategoryDAO;
import aplicacion.modelo.dominio.product.Category;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Lilia Said
 */
public class CategoryDAOImp implements Serializable, ICategoryDAO {

    @Override
    public void create(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        Session session = null;
        Category category = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            category = (Category) session.load(Category.class, categoryId);
            Hibernate.initialize(category);
        } catch (Exception e) {
            // si se produce un error
            // puedo obtener informacion con 
            // e.getMessage() que retorna un string
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return category;
    }

    @Override
    public List<Category> getCategoryList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Category.class);
        List<Category> categoryList = criteria.list();
        session.close();
        return categoryList;
    }

}
