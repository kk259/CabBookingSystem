package Service;

import Model.Driver;
import Model.User;
import Repository.DriverRepository;
import Repository.UserRepository;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CabService {
    DriverRepository driverRepository;
    UserRepository userRepository;
    public CabService(DriverRepository driverRepository ,UserRepository userRepository){
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
    }
    // add User
    public void createUser(User user){
        userRepository.createUser(user);
    }
    public int getDistance(Point p1,Point p2){
        double a= p1.getX() - p2.getX();
        double b= p1.getY() - p2.getY();
        return (int)  (Math.sqrt ((a*a) + (b*b)));
    }

    public List<Driver> sortDriversBasedonDistance(List<Driver> drivers,Point source){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<Driver> sortedDrivers = new ArrayList<>();
        List<Integer> distanceFromUser = new ArrayList<>();
        for(int i=0;i<drivers.size();i++){
            int distance = getDistance(source,drivers.get(i).getLocation());
            ArrayList<Integer>index =  map.getOrDefault(distance,null);
            if(index==null){
                distanceFromUser.add(distance);
                index = new ArrayList<>();
            }
            index.add(i);
            map.put(distance,index);
        }
        Collections.sort(distanceFromUser);
        for(int i=0;i<distanceFromUser.size();i++){
            for(int index :map.get(distanceFromUser.get(i))){
                sortedDrivers.add(drivers.get(index));
            }
        }
        return sortedDrivers;
    }
    // find available ride based on distance from user's location
    public void findRide(int userId,Point source,Point Destination){
        List<Driver> drivers = driverRepository.getAvailableDrivers();
        drivers = sortDriversBasedonDistance(drivers,source);
        for(Driver driver:drivers){
            System.out.println(driver +  " " + getDistance(source,driver.getLocation()));
        }
        System.out.println();
    }
    //bookRide
    public boolean bookRide(int customerId,int driverId){
        return driverRepository.assignCustomer(customerId,driverId);
    }
    // addDriver
    public boolean addDriver(Driver driver){
       return driverRepository.addDriver(driver);
    }
    // find ongoing rides
    public List<Driver> findOngoingRides(){
        return driverRepository.getOccupiedDrivers();
    }
}
