package Driver;

import Model.User;
import Model.Vehicle;
import Repository.RepositoryFactory;
import Service.CabService;

import javax.naming.OperationNotSupportedException;
import java.awt.*;

public class Driver {
    public static void main(String[] args) throws OperationNotSupportedException {
        CabService cabService = new CabService(RepositoryFactory.getRepository("driver")
                , RepositoryFactory.getRepository("user"));
        User user1 = new User(1, "Abhishek", 'M', 22);
        User user2 = new User(2, "Raj", 'M', 22);
        Model.Driver driver1 = new Model.Driver(1, 'M', 22, new Vehicle("KA-01-12345", "Swift"), new Point(10, 1));
        Model.Driver driver2 = new Model.Driver(2, 'M', 22, new Vehicle("KA-01-12456", "Swift"), new Point(11, 10));
        Model.Driver driver3 = new Model.Driver(3, 'M', 22, new Vehicle("KA-01-12347", "Swift"), new Point(5, 3));
        Model.Driver driver4 = new Model.Driver(4, 'M', 22, new Vehicle("KA-01-12349", "Swift"), new Point(5, 3));
        cabService.addDriver(driver1);
        cabService.addDriver(driver3);
        cabService.addDriver(driver2);
        cabService.addDriver(driver4);
        cabService.createUser(user1);
        cabService.createUser(user2);
        cabService.findRide(1, new Point(15, 6), new Point(20, 4));
        cabService.bookRide(1, 1);
        cabService.findRide(1, new Point(5, 6), new Point(20, 4));
        cabService.bookRide(2, 3);
        cabService.getAllUsers();
        cabService.getAllDrivers();
    }
}
