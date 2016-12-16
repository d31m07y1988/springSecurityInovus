package security.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import security.model.User;

import java.util.List;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository{

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        return (User)session.save(user);
    }

    @Override
    public User get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class,id);
    }

    @Override
    public User getByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).list();
    }
}