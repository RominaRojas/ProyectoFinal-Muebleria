/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio.order;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author laura
 */
public class Order implements Serializable{
    
    private int id;
    private int orderNumber;
    private int userId;
    private Calendar date;
    private int addressId;
    private int state;

    public Order() {
    }

    public Order(int id, int orderNumber, int userId, Calendar date, int addressId, int state) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.date = date;
        this.addressId = addressId;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
 
   
    
    
}
