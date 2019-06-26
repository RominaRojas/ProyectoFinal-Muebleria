/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UserBean;
import aplicacion.modelo.dominio.user.User;
import aplicacion.modelo.dominio.user.UserRole;
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

    /**
     * Se verifica el logueo.
     * @return
     */
    public String verifyCredentials() {
        String resultado = "";

        User user = userBean.verifyCredentials(email, password);
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            resultado = "index?faces-redirect=true";
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Accesso Denegado", "Credenciales Incorrectas"));

        }
        return resultado;
    }

    public String gotToSignUp() {
        return "sign-up?faces-redirect=true";
    }

    public String goToLogin() {
        return "login?faces-redirect=true";
    }

    public String goToAdminPanel() {
        return "admin?faces-redirect=true";
    }
    
    public String goToOrder() {
        return "order?faces-redirect=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

    public boolean isAdminUser(){
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        return user != null && user.getRole() == UserRole.administrator;
    }
    
    /**
     * Si hay un usuario en sesión retornará verdadero.
     *
     * @return
     */
    public boolean isLogged() {
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        return user != null;
    }

}
