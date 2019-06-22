/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IOrderDAO;
import aplicacion.hibernate.dao.imp.OrderDAOImp;
import aplicacion.modelo.dominio.order.Order;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class OrderBean {

   private IOrderDAO iOrderDAO;
   
    public OrderBean() {
        iOrderDAO = new OrderDAOImp();
    }

    public IOrderDAO getiUserDAO() {
        return iOrderDAO;
    }

    public void setiUserDAO(IOrderDAO iOrderDAO) {
        this.iOrderDAO = iOrderDAO;
    }
    
    public void create(Order order){
        iOrderDAO.create(order);
    }
    
    /**public int getLastOrderNumber(){
        iOrderDAO.getLastOrderNumber();
    }**/
    

}
