package pl.sda;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OwnerDAO {

    DataSource ds;
    public OwnerDAO(DataSource ds){
        this.ds = ds;
    }

    public List<Owner> getAllOwners(){
        try(Connection con = ds.getConnection()) {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from owner");
            List<Owner> owners = new ArrayList<Owner>();
            while(rs.next()){
                Owner o = new Owner();
                o.id = rs.getInt("id");
                o.name = rs.getString("name");
                DogDAO dd = new DogDAO(ds);
                o.dogs = dd.getAllDogs().stream().filter(d -> d.owner_id == o.id).collect(Collectors.toList());
                owners.add(o);
            }
            return owners;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Owner>();
    }
}
