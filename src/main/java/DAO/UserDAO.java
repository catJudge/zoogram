package DAO;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persistence.User;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public User getUserByUsername(String s) {
        final List<User> list = sessionFactory.getCurrentSession()
                .createQuery("from User where username = :username")
                .setParameter("username", s)
                .list();
        if (list.size() != 0) {
            final User user = list.get(0);
            Hibernate.initialize(user.getComments());
            Hibernate.initialize(user.getPosts());
            Hibernate.initialize(user.getLikes());
            Hibernate.initialize(user.getFollowees());
            Hibernate.initialize(user.getFollowers());
            return user;
        } else {
            return null;
        }
    }



}
