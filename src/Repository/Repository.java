package Repository;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface Repository<dataType> {

    /**
     * checks whether Id is not already used which will be assigned to this new entity
     * Then register a new Entity
     *
     * @param obj - Entity
     * @return
     */
    boolean create(dataType obj);

    /**
     * Finds a entity based on his/her id and returns the found entity
     *
     * @param id
     * @return
     */
    dataType findById(int id);

    /**
     * Returns all the members of the entitySet
     *
     * @return
     */
    List<dataType> findAll();

    /**
     * checks whether a entity is present in the system based on his/her ID
     *
     * @param id
     * @return
     */
    boolean existsById(int id);

    /**
     * When user books a ride
     * driver is assigned to the user
     *
     * @param driverId
     * @param customerId
     * @return
     * @throws OperationNotSupportedException
     */
    boolean assignCustomer(int driverId, int customerId) throws OperationNotSupportedException;
}
