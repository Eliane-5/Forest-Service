import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
public class EndangeredAnimals {
    private String name;
    private int animalId;
    private String health;
    private int age;
    private int id;
    public EndangeredAnimals(int animalId, String name, String health, int age){
        this.name = name;
        this.animalId = animalId;
        this.health = health;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAnimalId(){
        return animalId;
    }
    public String getHealth(){
        return health;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof EndangeredAnimals)) {
            return false;
        } else {
            EndangeredAnimals newAnimal = (EndangeredAnimals) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getAnimalId() == newAnimal.getAnimalId();
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalId, name, health, age) VALUES (:animalId, :name, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<EndangeredAnimals> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
        }
    }
    public static EndangeredAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            EndangeredAnimals animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimals.class);
            return animal;
        }
    }
}
