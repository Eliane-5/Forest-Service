import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
public class EndangeredAnimals {
    private String name;
    private int health;
    private int age;
    private int id;
    private String ageCalc;
    private String healthLevel;

    public static final int MID_HEALTH_LEVELS = 5;
    public static final int MIN_ALL_LEVELS = 1;
    public static final int MID_AGE_LEVELS = 6;

    public EndangeredAnimals(String name, int health, int age){
        this.name = name;
        this.health = health;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public String getHealthLevel(){
        if(this.health == MID_HEALTH_LEVELS){
            healthLevel = "okay";
        }
        else if(this.health>MID_HEALTH_LEVELS ){
            healthLevel = "healthy";
        }
        else {
            healthLevel = "ill";
        }
        return healthLevel;
    }
    public String getAgeCalc(){
        if(this.age<=MIN_ALL_LEVELS){
            ageCalc = "a newborn";
        }
        else if(this.age>=MIN_ALL_LEVELS && this.age<= MID_AGE_LEVELS ){
            ageCalc = "young";
        }
        else {
            ageCalc = "an adult";

        }
        return ageCalc;
    }
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
}
