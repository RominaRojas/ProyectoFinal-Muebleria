/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio.order;

/**
 *
 * @author Lilia Said
 */
public class OrderStatus {
    public static int pending = 0;
    public static int canceled = 1;
    public static int delivered = 2;

    public static String getStatusString(int status) {
        String result = "";

        switch (status) {
            case 0:
                result = "Pendiente";
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
}
