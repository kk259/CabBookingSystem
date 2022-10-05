package Repository;

import Model.Driver;

import java.util.List;

public interface Repository<dataType> {

    /**
     * checks whether Id is not already used which will be assigned to this new entity
     * Then register a new Entity
     * @param obj
     * @return
     */
    public boolean create(dataType obj);

    /**
     * Finds a entity based on his/her id and returns the found entity
     * @param id
     * @return
     */
    public dataType findById(int id);

    /**
     * Returns all the members of the entitySet
     * @return
     */
    public List<dataType> findAll();

    /**
     * checks whether a entity is present in the system based on his/her ID
     * @param id
     * @return
     */
    public boolean existsById(int id);
}
