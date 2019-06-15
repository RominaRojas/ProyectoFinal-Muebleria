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
import org.hibernate.Session;

/**
 *
 * @author LILI-PC
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

}
