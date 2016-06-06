package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import persistence.Post;
import persistence.User;
import service.CommentService;
import service.LikeService;
import service.PostService;
import service.UserService;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @Autowired
    LikeService likeService;
    @Autowired
    User currentUser;

    @RequestMapping(value = "/signup/", method = RequestMethod.GET)
    public ModelAndView signGet(ModelAndView modelAndView) {
        return new ModelAndView("signup");
    }

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/signup/", method = RequestMethod.POST)
    public ModelAndView signPost(
            @ModelAttribute("inputEmail") String inputEmail,
            @ModelAttribute("inputFullname") String inputFullname,
            @ModelAttribute("inputUsername") String inputUsername,
            @ModelAttribute("inputPassword") String inputPassword) {
        final User user = userService.insertUser(inputEmail, inputFullname, inputUsername, inputPassword);

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ModelAndView loginPost(
            @ModelAttribute("inputUsername") String inputUsername,
            @ModelAttribute("inputPassword") String inputPassword) {

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping(value = "/profile/{username}/", method = RequestMethod.GET)
    public ModelAndView profile(@PathVariable("username") String username) {
        ModelAndView modelAndView = new ModelAndView("profile");
        final User userByUsername = userService.getUserByUsername(username);
        if (userByUsername == null)
            modelAndView.setViewName("error");
        modelAndView.addObject("user", userByUsername);
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        final User userByUsername = userService.getUserByUsername("oodmi");
        if (userByUsername == null)
            modelAndView.setViewName("signup");
        modelAndView.addObject("posts", postService.getAllFromUserAndFollowees(userByUsername));
        return modelAndView;
    }

    @RequestMapping(value = "/profile/edit/{username}/", method = RequestMethod.GET)
    public ModelAndView editGet(@PathVariable("username") String username) {
        ModelAndView modelAndView = new ModelAndView("edit");
        return modelAndView;
    }

    @RequestMapping(value = "/post/{post}/", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable("post") Integer post) {
        ModelAndView modelAndView = new ModelAndView("post");
        final Post postById = postService.getPostById(post);
        modelAndView.addObject("post", postService.getPostById(post));
        return modelAndView;
    }

    @RequestMapping(value = "/post/{post}/add/comment/", method = RequestMethod.POST)
    public ModelAndView postAddComment(@PathVariable("post") Integer post,
                                       @ModelAttribute("inputComment") String inputComment) {
        ModelAndView modelAndView = new ModelAndView("post");
        commentService.insertComment(inputComment, post, userService.getUserByUsername("oodmi"));
        final Post postById = postService.getPostById(post);
        modelAndView.addObject("post", postService.getPostById(post));
        return modelAndView;
    }

    @RequestMapping(value = "/post/{post}/add/like/", method = RequestMethod.POST)
    public ModelAndView postAddLike(@PathVariable("post") Integer post) {
        ModelAndView modelAndView = new ModelAndView("post");
        likeService.insertLike(post, userService.getUserByUsername("oodmi"));
        final Post postById = postService.getPostById(post);
        modelAndView.addObject("post", postService.getPostById(post));
        return modelAndView;
    }

    @RequestMapping(value = "/add/post/", method = RequestMethod.POST)
    public ModelAndView addPost(@PathVariable("post") Integer post,
                                @ModelAttribute("inputDescription") String inputDescription) {
        ModelAndView modelAndView = new ModelAndView("post");
        return modelAndView;
    }
}
