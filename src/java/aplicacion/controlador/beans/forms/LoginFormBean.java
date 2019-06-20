/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UserBean;
import aplicacion.modelo.dominio.user.User;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable {

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private String email;
    private String password;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String verifyCredentials() {
        String resultado = "";
        
        User user = userBean.verifyCredentials(email, password);
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            resultado = "Home?faces-redirect=true";
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Accesso Denegado", "Credenciales Incorrectas"));
            
        }
        return resultado;
    }
    
    public String gotToSignUp(){
        return "Sign-up?faces-redirect=true";
    }
}
