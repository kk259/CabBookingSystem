package Repository;

import Model.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DriverRepository {
    List<Driver> availableDrivers;
    List<Driver> occupiedDrivers;

    public DriverRepository() {
        availableDrivers = new LinkedList<>();
        occupiedDrivers = new LinkedList<>();
    }
    public boolean addDriver(Driver driver){
        availableDrivers.add(driver);
        return true;
    }

    public boolean assignCustomer(int customerId,int driverId){
        for(int i=0;i<availableDrivers.size();i++){
            if(availableDrivers.get(i).getId()==driverId){
                availableDrivers.get(i).setCustomerId(customerId);
                occupiedDrivers.add(availableDrivers.get(i));
                availableDrivers.remove(availableDrivers.get(i));
                return true;
            }
        }
        return false;
    }
    public List<Driver> getAvailableDrivers(){
        return availableDrivers;
    }

    public List<Driver> getOccupiedDrivers(){
        return occupiedDrivers;
    }
}
