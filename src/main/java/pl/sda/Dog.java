package pl.sda;

public class Dog {
    public int id;
    public String name;
    public int owner_id;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
