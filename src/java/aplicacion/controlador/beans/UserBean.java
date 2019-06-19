/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.IUserDAO;
import aplicacion.hibernate.dao.imp.UserDAOImp;
import aplicacion.modelo.dominio.user.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class UserBean {

   private IUserDAO iUserDAO;
    public UserBean() {
        iUserDAO = new UserDAOImp();
    }
    
    public User verifyCredentials(String email, String password) {
     return iUserDAO.verifyCredentials(email, password);
    }

    public IUserDAO getiUserDAO() {
        return iUserDAO;
    }

    public void setiUserDAO(IUserDAO iUserDAO) {
        this.iUserDAO = iUserDAO;
    }
    
}
