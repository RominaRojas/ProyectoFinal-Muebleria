/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CategoryBean;
import aplicacion.modelo.dominio.product.Category;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author LILI-PC
 */
@ManagedBean
@RequestScoped
public class CategoryFormBean implements Serializable {
        
    @ManagedProperty(value = "#{categoryBean}")
    private CategoryBean categoryBean;

    private MenuModel categoryMenuModel;

    /**
     * Creates a new instance of CategoryFormBean
     */
    public CategoryFormBean() {

    }
    
    @PostConstruct
    public void init() {
        categoryMenuModel = new DefaultMenuModel();
        DefaultSubMenu subMenu = new DefaultSubMenu("Categorias");
        DefaultMenuItem item;
        
        int position = 0;
        for (Category category : categoryBean.getCategoryList()) {
            item = new DefaultMenuItem(category.getName());
            item.setCommand("#{productFormBean.filterByCategoryId("+category.getId()+")}");
            item.setUpdate(":product-form:product-grid");
            item.setOnsuccess("refreshCategorySelection(\""+Integer.toString(position)+"\")");
            subMenu.addElement(item);
            position++;
        }
        categoryMenuModel.addElement(subMenu);
    }

    public MenuModel getCategoryMenuModel() {
        return categoryMenuModel;
    }
    
    public CategoryBean getCategoryBean() {
        return categoryBean;
    }

    public void setCategoryBean(CategoryBean categoryBean) {
        this.categoryBean = categoryBean;
    }

}
