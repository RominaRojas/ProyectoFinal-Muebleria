package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.user.User;
import java.util.List;

/**
 *
 * @author Lilia Said
 */
public interface IUserDAO {

    void create(User user);

    void update(User user);

    void delete(User user);

    User getUserById(int userId);

    User getUserByEmail(String email);

    List<User> getUserList();

    User verifyCredentials(String email, String password);
}
