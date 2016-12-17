package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.dto.UserTO;
import security.error.UserAlreadyExistException;
import security.model.Role;
import security.model.User;
import security.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service("userSevice")
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository repository;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByLogin(String login) {
        return repository.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Transactional
    @Override
    public User registerNewUserAccount(final UserTO userTO) throws UserAlreadyExistException {
        if (loginExist(userTO.getLogin())) {
            throw new UserAlreadyExistException("Пользователь с логином " + userTO.getLogin() + " уже зарегистрирован");
        }
        User user = new User();
        user.setLogin(userTO.getLogin());
        String codedPassword = passwordEncoder.encodePassword(userTO.getPassword(), null);
        user.setPassword(codedPassword);
        user.setRoles(Arrays.asList(Role.ROLE_USER));
        return save(user);
    }

    private boolean loginExist(String login) {
        return getByLogin(login) != null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByLogin(username);

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), user.getRoles());
    }
}
