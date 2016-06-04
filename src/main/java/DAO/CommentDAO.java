package DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persistence.Comment;

@Repository
@Transactional
public class CommentDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void insertComment(Comment comment) {
        sessionFactory.getCurrentSession().save(comment);
    }

    public void deleteComment(Comment comment) {
        sessionFactory.getCurrentSession().delete(comment);
    }

}

