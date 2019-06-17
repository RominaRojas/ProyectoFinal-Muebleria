package aplicacion.test;

import aplicacion.hibernate.dao.ICategoryDAO;
import aplicacion.hibernate.dao.imp.CategoryDAOImp;
import aplicacion.modelo.dominio.product.Category;
import aplicacion.modelo.dominio.product.Product;

/**
 *
 * @author Lilia Said
 */
public class TestCreateCategory {

    public static void main(String[] args) {
        
        Category category = new Category();
        category.setName("Sillas");
        
        category.addProductList(new Product(
                  1, 200, 500, "Silla PVC", "Garden Life c/apoya brazos"));
                
        ICategoryDAO categoryDAO = new CategoryDAOImp();
        categoryDAO.create(category);
        
    }

}
