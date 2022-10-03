package Repository;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public boolean createUser(User user){
        users.add(user);
        return true;
    }
}
