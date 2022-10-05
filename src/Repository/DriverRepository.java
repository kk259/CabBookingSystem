package Repository;

import Model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository implements Repository<Driver>{
    List<Driver> drivers;
    public DriverRepository() {
        drivers = new ArrayList<>();
    }

    public boolean create(Driver driver){
        if(existsById(driver.getId())){
            return false;
        }
        drivers.add(driver);
        return true;
    }

    public Driver findById(int driverId){
        for(int i=0;i<drivers.size();i++){
            if(drivers.get(i).getId()==driverId){
                return drivers.get(i);
            }
        }
        return null;
    }


    public boolean existsById(int driverId){
        for(int i=0;i<drivers.size();i++){
            if(drivers.get(i).getId()==driverId){
                return true;
            }
        }
        return false;
    }

    public List<Driver> findAll(){
        return drivers;
    }

}
