package Repository;

import Model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository implements Repository<Driver> {
    List<Driver> drivers;

    public DriverRepository() {
        drivers = new ArrayList<>();
    }

    @Override
    public boolean create(Driver driver) {
        if (existsById(driver.getId())) {
            return false;
        }
        drivers.add(driver);
        return true;
    }

    @Override
    public Driver findById(int driverId) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getId() == driverId) {
                return drivers.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean existsById(int driverId) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getId() == driverId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Driver> findAll() {
        return drivers;
    }

    /**
     * When user books a ride
     * driver is assigned to the user
     *
     * @param driverId
     * @param customerId
     * @return
     */

    @Override
    public boolean assignCustomer(int driverId, int customerId) {
        Driver driver = findById(driverId);
        if (driver == null || driver.getCustomerId() != 0) {
            return false;
        }
        driver.setCustomerId(customerId);
        return true;
    }
}
