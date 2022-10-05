package Service;

import Model.Driver;
import Model.User;
import Model.Vehicle;
import Repository.Repository;

import javax.naming.OperationNotSupportedException;
import java.awt.*;
import java.util.List;
import java.util.*;

public class CabService {
    Repository driverRepository;
    Repository userRepository;

    public CabService(Repository driverRepository,
                      Repository userRepository) {
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
    }

    public boolean validateItIsPositive(int id) {
        return id >= 1;
    }

    public boolean validateName(String name) {
        return name != null;
    }

    public boolean validateLocation(Point location) {
        return !(location.getX() < 0) && !(location.getY() < 0);
    }

    public boolean validateGender(char gender) {
        return gender == 'M' || gender == 'F';
    }

    public boolean validateVehicle(Vehicle vehicle) {
        return vehicle.getCompany() != null && vehicle.getLicense() != null;
    }

    /**
     * Validate the user details before Registration
     * as well as checks whether userId is not already used
     * Then register a new user
     *
     * @param user
     */
    public void createUser(User user) {
        if (!(validateItIsPositive(user.getId()) && validateItIsPositive(user.getAge())
                && validateName(user.getName()) && validateGender(user.getGender()))) {
            System.out.println("Incorrect Input");
            return;
        }
        if (userRepository.create(user)) {
            System.out.println("User added Successfully");
        } else {
            System.out.println("User addition failure");
        }
    }

    /**
     * Sort drivers based on their distance from user's location
     *
     * @param drivers
     * @param source
     * @param distanceFromSource
     * @return
     */
    public List<Driver> sortDriversByDistanceFromSource(List<Driver> drivers, Point source, HashMap<Point, Integer> distanceFromSource) {
        Distance d = (a, b) -> (int) (Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2)));
        for (Driver driver : drivers) {
            if (distanceFromSource.get(driver.getLocation()) == null) {
                distanceFromSource.put(driver.getLocation(), d.getDistance(source, driver.getLocation()));
            }
        }
        Collections.sort(drivers, Comparator.comparingInt(a -> d.getDistance(a.getLocation(), source)));
        return drivers;
    }

    public void getAllUsers() {
        userRepository.findAll().stream().forEach(System.out::println);
    }

    /**
     * check whether valid user is trying to find ride
     * finds the available drivers and display them based on their distance from user's location
     *
     * @param userId
     * @param source
     * @param Destination
     */
    public void findRide(int userId, Point source, Point Destination) {
        if (!(validateItIsPositive(userId) && validateLocation(source) && validateLocation(Destination))) {
            System.out.println("Incorrect Input");
            return;
        }
        if (!userRepository.existsById(userId)) {
            System.out.println("To find or book a ride, firstly create user");
            return;
        }
        HashMap<Point, Integer> distanceFromSource = new HashMap<>();
        List<Driver> drivers = driverRepository.findAll();
        List<Driver> availableDrivers = new ArrayList<>();
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getCustomerId() == 0) {
                availableDrivers.add(drivers.get(i));
            }
        }
        drivers = sortDriversByDistanceFromSource(availableDrivers, source, distanceFromSource);
        for (Driver driver : availableDrivers) {
            System.out.println(driver + " " + distanceFromSource.get(driver.getLocation()));
        }
    }

    /**
     * checks whether userId is valid if so then
     * user's chosen ride is booked for him if he's trying to book a valid ride
     *
     * @param userId
     * @param driverId
     */
    public void bookRide(int userId, int driverId) throws OperationNotSupportedException {
        if (!userRepository.existsById(userId)) {
            System.out.println("firstly, create user in the system");
            return;
        }
        if (!driverRepository.assignCustomer(driverId, userId)) {
            System.out.println("can't book ride at this time");
        } else {
            System.out.println("Ride booked");
        }
        System.out.println();
    }

    /**
     * Validate the driver details before Registration
     * as well as checks whether driverId is not already used
     * Then register a new driver
     *
     * @param driver
     */
    public void addDriver(Driver driver) {
        if (!(validateItIsPositive(driver.getId()) && validateItIsPositive(driver.getAge())
                && validateGender(driver.getGender()) && validateLocation(driver.getLocation()) && validateVehicle(driver.getVehicle()))) {
            System.out.println("Incorrect Input");
            return;
        }
        if (driverRepository.create(driver)) {
            System.out.println("Driver added successfully");
        } else {
            System.out.println("Driver addition failure");
        }
    }

    public void getAllDrivers() {
        driverRepository.findAll().stream().forEach(System.out::println);
    }

    private interface Distance {
        int getDistance(Point p1, Point p2);
    }

}
