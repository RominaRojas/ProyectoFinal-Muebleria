/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio.user;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Romina Rojas
 */
public class User implements Serializable{
    private int id;
    private String surname;
    private String name;
    private int dni;
    private String email;
    private Calendar dateOfBirth;
    private String password;

    public User(int id, String surname, String name, int dni, String email, Calendar dateOfBirth, String password) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    /**
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the DNI
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the DateOfBirth
     */
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth
     */
    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
