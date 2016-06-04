package service;

import DAO.LikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.Like;

@Service
public class LikeService {
    @Autowired
    LikeDAO likeDAO;

    public void insertLike(Like like) {
        likeDAO.insertLike(like);
    }

    public void deleteLike(Like like) {
        likeDAO.deleteLike(like);
    }
}
