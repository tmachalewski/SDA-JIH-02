package pl.sda;

import java.util.List;

public class Owner {
    public int id;
    public String name;
    public List<Dog> dogs;

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dogs=" + dogs +
                '}';
    }
}
