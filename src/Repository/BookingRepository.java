package Repository;

import Model.Driver;

public class BookingRepository {
    /**
     * When user books a ride
     * driver is assigned to the user
     * @param driver
     * @param customerId
     * @return
     */
    public boolean assignCustomer(Driver driver, int customerId){
        if(driver.getCustomerId()!=0){
            return false;
        }
        driver.setCustomerId(customerId);
        return true;
    }
}
