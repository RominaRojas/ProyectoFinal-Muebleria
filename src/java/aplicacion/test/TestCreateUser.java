package aplicacion.test;

import aplicacion.hibernate.dao.IUserDAO;
import aplicacion.hibernate.dao.imp.UserDAOImp;
import aplicacion.modelo.dominio.user.User;
import java.util.Calendar;

/**
 *
 * @author Lilia Said
 */
public class TestCreateUser {

    public static void main(String[] args) {
        User user = new User(1, "Ortega", "Leandro", 123456789, "leandro@g-ortega.com.ar",
                Calendar.getInstance(), "blablablabla", 0);

        IUserDAO userDAO = new UserDAOImp();
        userDAO.create(user);
    }

}
