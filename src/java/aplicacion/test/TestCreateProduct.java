package aplicacion.test;


import aplicacion.hibernate.dao.IProductDAO;
import aplicacion.hibernate.dao.imp.ProductDAOImp;
import aplicacion.modelo.dominio.product.Product;

/**
 *
 * @author Lilia Said
 */
public class TestCreateProduct {

    public static void main(String[] args) {
        
        Product product = new Product(
                1, 200, 500, "Silla PVC", "Garden Life c/apoya brazos");
        
        IProductDAO productDAO = new ProductDAOImp();
        productDAO.create(product);
        
    }

}
