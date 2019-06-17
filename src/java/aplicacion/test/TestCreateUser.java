package aplicacion.test;

import aplicacion.hibernate.dao.IUserDAO;
import aplicacion.hibernate.dao.imp.UserDAOImp;
import aplicacion.modelo.dominio.user.User;
import aplicacion.modelo.dominio.user.UserRole;
import java.util.Calendar;

/**
 *
 * @author Lilia Said
 */
public class TestCreateUser {

    public static void main(String[] args) {
        User user = new User(1, "Said", "Lilia", 123456789, "lilia@test.com",
                Calendar.getInstance(), "1234", UserRole.user);

        IUserDAO userDAO = new UserDAOImp();
        userDAO.create(user);
    }

}
