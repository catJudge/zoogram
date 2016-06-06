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

    public void getLikesByPostId(Integer integer){
        sessionFactory.getCurrentSession().createQuery("from _like where post.id = :pid").setParameter("pid", integer);
    }
}
