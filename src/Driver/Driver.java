package Driver;

import Model.User;
import Model.Vehicle;
import Repository.DriverRepository;
import Repository.UserRepository;
import Service.CabService;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.List;

public class Driver {
    static CabService cabService;
    public Driver(){
        cabService = new CabService(new DriverRepository(),new UserRepository());
    }
    public static void main(String args[]){
        Driver d = new Driver();
        User user = new User(1,"Abhishek",'M',22);
        Model.Driver driver1 = new Model.Driver(1,'M',22,new Vehicle("KA-01-12345","Swift"),new Point(10,1));
        Model.Driver driver2 = new Model.Driver(2,'M',22,new Vehicle("KA-01-12345","Swift"),new Point(11,10));
        Model.Driver driver3 = new Model.Driver(3,'M',22,new Vehicle("KA-01-12345","Swift"),new Point(5,3));
        cabService.addDriver(driver1);
        cabService.addDriver(driver2);
        cabService.addDriver(driver3);
        cabService.createUser(user);
        cabService.findRide(1,new Point(15,6),new Point(20,4));
        cabService.bookRide(1,1);
        cabService.findRide(1,new Point(5,6),new Point(20,4));
        cabService.bookRide(1,2);
        cabService.findRide(1,new Point(5,6),new Point(20,4));
        //List<Model.Driver> occupiedDrivers  = cabService.findOngoingRides();
        //d.displayDrivers(occupiedDrivers);
        //d.displayDrivers(freeDrivers);
    }
}
