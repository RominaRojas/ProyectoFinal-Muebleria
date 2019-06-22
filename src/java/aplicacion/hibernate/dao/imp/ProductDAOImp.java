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
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Lilia Said
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

    @Override
    public void update(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Product getProductById(int productId) {
        Session session = null;
        Product product = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            product = (Product) session.load(Product.class, productId);
            Hibernate.initialize(product);
        } catch (Exception e) {
            // si se produce un error
            // puedo obtener informacion con 
            // e.getMessage() que retorna un string
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> getProductList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Product.class);
        List<Product> productList = criteria.list();
        session.close();
        return productList;
    }

    @Override
    public List<Product> getProductListByCategoryId(int categoryId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Product.class);
                
        criteria.add(Restrictions.          
                sqlRestriction("{alias}.category_id = "+Integer.toString(categoryId))
        );
        return criteria.list();
    }

}
