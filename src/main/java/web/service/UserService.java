package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void removeUser(User user);

    List<User> getAllUsers();

    User show(int id);

    void update(User user);
}
