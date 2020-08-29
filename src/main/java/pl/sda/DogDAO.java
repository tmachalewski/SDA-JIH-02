package pl.sda;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogDAO {

    DataSource ds;

    public Map<Integer, Dog> dogRepository = new HashMap<>();
    public DogDAO(DataSource ds){
        this.ds = ds;
    }

    public List<Dog> getAllDogs(){
        try(Connection con = ds.getConnection()) {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from dog");
            List<Dog> dogs = new ArrayList<Dog>();
            while(rs.next()){
                Dog d = new Dog();
                d.id = rs.getInt("id");
                d.name = rs.getString("name");
                d.owner_id = rs.getInt("owner_id");
                if (dogRepository.containsKey(d.id)) {
                    dogs.add(dogRepository.get(d.id));
                } else
                {
                    dogRepository.put(d.id, d);
                    dogs.add(d);
                }
            }
            return dogs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Dog>();
    }
}
