/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lilia Said
 */
public class OrderStatus {
    public static int purchased = 0;
    public static int canceled = 1;
    public static int delivered = 2;
    
    private int id;
    private String name;

    public OrderStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }
           
    public static String getStatusString(int status) {
        String result = "";

        switch (status) {
            case 0:
                result = "Comprado";
                break;
            case 1:
                result = "Cancelado";
                break;
            case 2:
                result = "Entregado";
                break;
        }

        return result;
    }
    
    public static List<OrderStatus> getStatusList() {
        List<OrderStatus> status = new ArrayList();
        status.add(new OrderStatus(purchased, getStatusString(purchased)));
        status.add(new OrderStatus(canceled, getStatusString(canceled)));
        status.add(new OrderStatus(delivered, getStatusString(delivered)));
        return status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
