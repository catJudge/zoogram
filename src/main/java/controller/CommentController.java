package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.CommentService;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
}
