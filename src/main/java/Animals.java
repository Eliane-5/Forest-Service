import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Animals {
    private String name;
    private int id;

    public Animals(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animals)) {
            return false;
        } else {
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Animals> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }
    }
    public static Animals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
             Animals animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animals.class);
            return animal;
        }
    }
    public List<EndangeredAnimals> getEndangeredAnimals() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where animalId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(EndangeredAnimals.class);
        }
    }
}
