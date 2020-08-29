package pl.sda;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {
    public static void main(String[] args) {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(ConnectionProperties.DB_URL);
        ds.setUser(ConnectionProperties.USER);
        ds.setPassword(ConnectionProperties.PASS);

        DogDAO dd = new DogDAO(ds);
        OwnerDAO od = new OwnerDAO(ds);
        //dd.getAllDogs().forEach(System.out::println);
        od.getAllOwners().forEach(System.out::println);
    }
}
