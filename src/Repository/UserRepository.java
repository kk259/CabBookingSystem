package Repository;

import Model.User;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {
    List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public boolean create(User user) {
        if (existsById(user.getId())) {
            return false;
        }
        users.add(user);
        return true;
    }

    @Override
    public User findById(int userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public boolean existsById(int userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean assignCustomer(int driverId, int customerId) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

}
