package DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persistence.Comment;
import persistence.Like;

@Repository
@Transactional
public class LikeDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void insertLike(Like like) {
        sessionFactory.getCurrentSession().save(like);
    }

    public void deleteLike(Like like) {
        sessionFactory.getCurrentSession().delete(like);
    }
}
