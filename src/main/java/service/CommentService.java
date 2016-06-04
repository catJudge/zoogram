package service;

import DAO.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.Comment;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;

    public void insertComment(Comment comment) {
        commentDAO.insertComment(comment);
    }

    public void deleteComment(Comment comment) {
        commentDAO.deleteComment(comment);
    }
}
