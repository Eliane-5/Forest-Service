import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
public class EndangeredAnimals {
    private String name;
    private String health;
    private int age;
    private int id;
    private int ageCalc;
    private int healthLevel;

    public static final int MAX_HEALTH_LEVEL = 10;
    public static final int MAX_AGE_LEVEL = 10;
    public static final int MIN_ALL_LEVELS = 0;
    public EndangeredAnimals(String name, String health, int age){
        this.name = name;
        this.health = health;
        this.age = age;
        this.healthLevel = MAX_HEALTH_LEVEL/2;
        this.ageCalc = MAX_AGE_LEVEL /2;
    }
    public String getName(){
        return name;
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
    public int getHealthLevel(){
        return healthLevel;
    }
    public int getAgeCalc(){
        return ageCalc;
    }
//    @Override
//    public boolean equals(Object otherAnimal){
//        if (!(otherAnimal instanceof EndangeredAnimals)) {
//            return false;
//        } else {
//            EndangeredAnimals newAnimal = (EndangeredAnimals) otherAnimal;
//            return this.getName().equals(newAnimal.getName()) &&
//                    this.getAnimalId() == newAnimal.getAnimalId();
//        }
//    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangeredanimal (name, health, age) VALUES (:name, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<EndangeredAnimals> all() {
        String sql = "SELECT * FROM endangeredanimal";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
        }
    }
    public static EndangeredAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangeredanimal where id=:id";
            EndangeredAnimals animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimals.class);
            return animal;
        }
    }
    public List<Sightings> getSightings() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where animalId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sightings.class);
        }
    }
}
