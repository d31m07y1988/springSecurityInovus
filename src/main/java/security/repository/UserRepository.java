package security.repository;

import security.model.User;

import java.util.List;

/**
 * Created by Ramil on 15.12.2016.
 */
public interface UserRepository {

    User save(User user);

    // null if not found
    User get(int id);

    // null if not found
    User getByLogin(String login);

    List<User> getAll();
}
