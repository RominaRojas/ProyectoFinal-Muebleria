/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.OrderBean;
import aplicacion.controlador.beans.UserBean;
import aplicacion.modelo.dominio.order.Order;
import aplicacion.modelo.dominio.user.User;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class OrderFormBean implements Serializable {

    @ManagedProperty(value = "#{orderBean}")
    private OrderBean orderBean;
    private List<Order> orderList;
    private User user;

    /**
     * Creates a new instance of LoginFormBean
     */
    public OrderFormBean() {
    }

    @PostConstruct
    public void init() {

        user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        if (user != null) {
            orderList = orderBean.getOrderListByUserId(user.getId());
        } else {
            redirectToLogin();
        }

    }

    private void redirectToLogin() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
        }
    }

    public void downloadOrderList() throws JRException, IOException {

        Map<String, Object> parametros = new HashMap<String, Object>();
        
        List<Order> orderList = new ArrayList();
        orderList = orderBean.getOrderListByUserId(user.getId());
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/orderReport.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(orderList));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=pedidos-report.pdf");
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();

    }

    public String getOrderLink(String orderId) {
        return "order-view.xhtml?faces-redirect=true&id=" + orderId;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}
