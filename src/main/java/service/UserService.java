package service;

import DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User insertUser(User user) {
        userDAO.insertUser(user);
        return user;
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public User getUserByUsername(String s) {
        return userDAO.getUserByUsername(s);
    }

    public User insertUser(String inputEmail, String inputFullname, String inputUsername, String inputPassword) {
        User user = new User();
        user.setEmail(inputEmail);
        user.setName(inputFullname);
        user.setUsername(inputUsername);
        user.setPassword(inputPassword);
        return insertUser(user);
    }
}
