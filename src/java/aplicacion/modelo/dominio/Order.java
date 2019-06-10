/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.util.Calendar;

/**
 *
 * @author laura
 */
public class Order {
    
    private int ID;
    private int Order_Number;
    private int UserID;
    private Calendar Date;
    private int AddressId;
    private String State;

    public Order() {
    }

    public Order(int ID, int Order_Number, int UserID, Calendar Date, int AddressId, String State) {
        this.ID = ID;
        this.Order_Number = Order_Number;
        this.UserID = UserID;
        this.Date = Date;
        this.AddressId = AddressId;
        this.State = State;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrder_Number() {
        return Order_Number;
    }

    public void setOrder_Number(int Order_Number) {
        this.Order_Number = Order_Number;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Calendar getDate() {
        return Date;
    }

    public void setDate(Calendar Date) {
        this.Date = Date;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
    
 
   
    
    
}
