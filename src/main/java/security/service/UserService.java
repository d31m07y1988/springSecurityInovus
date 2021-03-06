package security.service;

import security.dto.UserTO;
import security.error.UserAlreadyExistException;
import security.model.User;

import java.util.List;

/**
 * Created by Ramil on 15.12.2016.
 */
public interface UserService {

    User save(User user);

    // null if not found
    User get(int id);

    // null if not found
    User getByLogin(String login);

    List<User> getAll();

    User registerNewUserAccount(UserTO userTO) throws UserAlreadyExistException;
}