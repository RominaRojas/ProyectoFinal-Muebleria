package aplicacion.test;

import aplicacion.hibernate.dao.IOrderDAO;
import aplicacion.hibernate.dao.IUserDAO;
import aplicacion.hibernate.dao.imp.OrderDAOImp;
import aplicacion.hibernate.dao.imp.UserDAOImp;
import aplicacion.modelo.dominio.order.Order;
import aplicacion.modelo.dominio.order.OrderItem;
import aplicacion.modelo.dominio.order.OrderStatus;
import aplicacion.modelo.dominio.product.Product;
import aplicacion.modelo.dominio.user.User;
import aplicacion.modelo.dominio.user.UserRole;
import java.util.Calendar;

/**
 *
 * @author Lilia Said
 */
public class TestCreateOrder {

    public static void main(String[] args) {

       
        Product product = new Product(
                 1, 200, 500, "Silla PVC", "Garden Life c/apoya brazos");
        
        
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(product.getPrice());
        orderItem.setQuantity(1);
        orderItem.setProductName(product.getName());
        
        User user = new User();
        user.setDateOfBirth(Calendar.getInstance());
        user.setDni(123456789);
        user.setEmail("lilia@test.com");
        user.setName("Lilia");
        user.setSurname("Said");
        user.setPassword("1234");
        user.setRole(UserRole.user);
        
        IUserDAO userDAO = new UserDAOImp();
        userDAO.create(user);
        
        Order order = new Order();
        order.addItem(orderItem);
        order.setOrderNumber(10000005);
        order.setState(OrderStatus.purchased);
        order.setUser(user);
        order.setCreatedAt(Calendar.getInstance());
        
        IOrderDAO orderDAO = new OrderDAOImp();
        orderDAO.create(order);
        
    }

}
