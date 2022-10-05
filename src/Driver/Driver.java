package Driver;

import Model.User;
import Model.Vehicle;
import Repository.BookingRepository;
import Repository.DriverRepository;
import Repository.RepositoryFactory;
import Repository.UserRepository;
import Service.CabService;

import java.awt.*;

public class Driver {
    public static void main(String args[]){
        CabService cabService = new CabService(RepositoryFactory.getRepository("driver")
                ,RepositoryFactory.getRepository("user"),new BookingRepository());
        User user = new User(1,"Abhishek",'M',22);
        Model.Driver driver1 = new Model.Driver(1,'M',22,new Vehicle("KA-01-12345","Swift"),new Point(10,1));
        Model.Driver driver2 = new Model.Driver(2,'T',22,new Vehicle("KA-01-12345","Swift"),new Point(11,10));
        Model.Driver driver3 = new Model.Driver(3,'M',22,new Vehicle("KA-01-12345","Swift"),new Point(5,3));
        Model.Driver driver4 = new Model.Driver(4,'M',22,new Vehicle("KA-01-12345","Swift"),new Point(5,3));
        try{
            cabService.addDriver(driver1);
            cabService.addDriver(driver3);
            cabService.addDriver(driver2);
            cabService.addDriver(driver4);
        }catch (Exception e){
            System.out.println("can't add driver");
        }
        cabService.createUser(new User(-1,null,'T',-1));
        cabService.createUser(user);
        cabService.findRide(1,new Point(15,6),new Point(20,4));
        cabService.bookRide(1,1);
        cabService.findRide(1,new Point(5,6),new Point(20,4));
        cabService.bookRide(1,2);
        cabService.findRide(1,new Point(5,6),new Point(20,4));
        cabService.getAllUsers();
    }
}
