package service;

import DAO.LikeDAO;
import DAO.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.Like;
import persistence.User;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class LikeService {
    @Autowired
    LikeDAO likeDAO;
    @Autowired
    PostDAO postDAO;

    public void insertLike(Like like) {
        likeDAO.insertLike(like);
    }

    public void deleteLike(Like like) {
        likeDAO.deleteLike(like);
    }

    public void insertLike(Integer post, User user) {
        Like  like = new Like();
        like.setUser(user);
        like.setPost(postDAO.getPostById(post));
        like.setCreatedDate(Timestamp.from(Instant.now()));
        insertLike(like);
    }
}
