package DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persistence.Post;

@Repository
@Transactional
public class PostDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void insertPost(Post post) {
        sessionFactory.getCurrentSession().save(post);
    }

    public void deletePost(Post post) {
        sessionFactory.getCurrentSession().delete(post);
    }

}
