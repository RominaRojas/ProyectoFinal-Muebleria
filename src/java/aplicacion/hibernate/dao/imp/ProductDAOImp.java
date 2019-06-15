/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao.imp;

import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IProductDAO;
import aplicacion.modelo.dominio.product.Product;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author LILI-PC
 */
public class ProductDAOImp implements Serializable, IProductDAO {

    @Override
    public void create(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

}
