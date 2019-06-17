/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.product.Category;
import java.util.List;

/**
 *
 * @author Lilia Said
 */
public interface ICategoryDAO {

    void create(Category category);

    void update(Category category);

    void delete(Category category);

    Category getCategoryById(int categoryId);

    List<Category> getCategoryList();
}
