/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author laura
 */
public class Order implements Serializable {

    private int id;
    private int orderNumber;
    private int userId;
    private Calendar createdAt;
    private int state;
    private List<OrderItem> itemList = new ArrayList<>();

    public Order() {
        
    }

    public Order(int id, int orderNumber, int userId, Calendar date, int state, List<OrderItem> itemList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.createdAt = date;
        this.state = state;
        this.itemList = itemList;
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

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the itemList
     */
    public List<OrderItem> getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public void addItem(OrderItem item) {
        this.itemList.add(item);
    }
}
