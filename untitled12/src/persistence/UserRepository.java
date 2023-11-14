package persistence;

import models.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);
    User getUser(String login);
    List<User> allUsers();
}
