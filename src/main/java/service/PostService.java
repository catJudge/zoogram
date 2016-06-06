package service;

import DAO.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.Post;
import persistence.User;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;

    public void insertPost(Post post) {
        postDAO.insertPost(post);
    }

    public void deletePost(Post post) {
        postDAO.deletePost(post);
    }

    public Post getPostById(Integer integer) {
        return postDAO.getPostById(integer);
    }

    public List<Post> getAllFromUserAndFollowees(User user) {
        return postDAO.getAllFromUserAndFollowees(user);
    }
}
