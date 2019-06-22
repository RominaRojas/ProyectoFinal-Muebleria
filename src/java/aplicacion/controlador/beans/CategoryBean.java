/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.hibernate.dao.ICategoryDAO;
import aplicacion.hibernate.dao.imp.CategoryDAOImp;
import aplicacion.modelo.dominio.product.Category;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author LILI-PC
 */
@ManagedBean
@RequestScoped
public class CategoryBean {

    ICategoryDAO iCategoryDAO;

    /**
     * Creates a new instance of CategoryBean
     */
    public CategoryBean() {
        iCategoryDAO = new CategoryDAOImp();
    }

    public ICategoryDAO getiCategoryDAO() {
        return iCategoryDAO;
    }

    public void setiCategoryDAO(ICategoryDAO iCategoryDAO) {
        this.iCategoryDAO = iCategoryDAO;
    }

    public List<Category> getCategoryList(){
        return iCategoryDAO.getCategoryList();
    }
}
