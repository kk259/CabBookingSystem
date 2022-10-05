package Repository;

public class RepositoryFactory {
    public static Repository getRepository(String type){
        if(type=="user"){
            return new UserRepository();
        }
        else{
            return new DriverRepository();
        }
    }

}
