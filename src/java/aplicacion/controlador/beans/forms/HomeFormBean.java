/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CategoryBean;
import aplicacion.modelo.dominio.product.Category;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author LILI-PC
 */
@ManagedBean
@RequestScoped
public class HomeFormBean {
    @ManagedProperty(value = "#{categoryBean}")
    private CategoryBean categoryBean;
    /**
     * Creates a new instance of HomeFormBean
     */
    public HomeFormBean() {
    }
    
    public List<Category> getCategoryList(){
        return categoryBean.getCategoryList();
    }
}
