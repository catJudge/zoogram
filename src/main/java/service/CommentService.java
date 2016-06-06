package service;

import DAO.CommentDAO;
import DAO.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.Comment;
import persistence.User;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;
    @Autowired
    PostDAO postDAO;

    public void insertComment(Comment comment) {
        commentDAO.insertComment(comment);
    }

    public void deleteComment(Comment comment) {
        commentDAO.deleteComment(comment);
    }

    public void insertComment(String inputComment, Integer post, User user) {
        Comment comment = new Comment();
        comment.setText(inputComment);
        comment.setPost(postDAO.getPostById(post));
        comment.setUser(user);
        comment.setCreatedDate(Timestamp.from(Instant.now()));
        insertComment(comment);
    }
}
