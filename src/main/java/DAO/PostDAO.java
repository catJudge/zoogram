package DAO;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persistence.Post;
import persistence.User;

import java.util.List;

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

    public Post getPostById(Integer integer) {
        final Post post = (Post) sessionFactory.getCurrentSession().get(Post.class, integer);
        Hibernate.initialize(post.getComments());
        Hibernate.initialize(post.getLikes());
        return post;

    }

    public List<Post> getPostsByUserId(Integer integer) {
        final List cid = sessionFactory.getCurrentSession().
                createQuery("from User where id= :cid").
                setParameter("cid", integer).list();
        final User user = (User) cid.get(0);
        return (List<Post>) user.getPosts();
    }

    public List<Post> getAllFromUserAndFollowees(User user) {
        List<Post> posts = getPostsByUserId(user.getId());
        for (User user1 : user.getFollowees()) {
            posts.addAll(getPostsByUserId(user1.getId()));
        }
        return posts;
    }

}
