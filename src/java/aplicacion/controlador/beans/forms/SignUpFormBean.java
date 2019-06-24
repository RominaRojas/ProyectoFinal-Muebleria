/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UserBean;
import aplicacion.modelo.dominio.user.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author LILI-PC
 */
@ManagedBean
@RequestScoped
public class SignUpFormBean implements Serializable {

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private String name;
    private String surname;
    private String email;
    private int dni;
    private Date dateOfBirth;
    private String password;

    public SignUpFormBean() {
    }
    
    /**
     * Corrobora que no existan dos usuarios con un mismo email.
     * @return 
     */
    public String registerNewUser() {
        String result = "";
        
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(this.dateOfBirth);
        
        User newUser = new User();
        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setDni(dni);
        newUser.setDateOfBirth(dateOfBirth);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(UserRole.user);

        if (userBean.isEmailRegistered(email)) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en registro", "Ese E-mail ya se encuentra en uso"));
        } else {
            userBean.registerNewUser(newUser);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userBean.getUserByEmail(email));
            result = "index?faces-redirect=true";
        }

        return result;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
}
