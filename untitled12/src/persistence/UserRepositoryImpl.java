package persistence;

import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository{

    private final Map<String, User> storageUser;
    private static UserRepository INSTANCE;

    private UserRepositoryImpl() {
        this.storageUser = new HashMap<>();
    }

    public static UserRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new UserRepositoryImpl();
        }
        return INSTANCE;
    }

    @Override
    public void saveUser(User user) {
        storageUser.put(user.getLogin(), user);
    }

    @Override
    public User getUser(String login) {
        return storageUser.get(login);
    }

    @Override
    public List<User> allUsers() {
        List<User> allUserList = storageUser.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return allUserList;
    }
}
