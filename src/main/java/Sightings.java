import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Sightings {
    private String animalName;
    private String location;
    private String rangerName;
    private int id;

    public Sightings(String animalName,String location,String rangerName){
        this.animalName = animalName;
        this.location= location;
        this.rangerName = rangerName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }
    public int getId(){
        return id;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalName,location,rangerName) VALUES (:animalName,:location,:rangerName)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalName", this.animalName)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }
    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sightings sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sighting;
        }
    }
//    public List<Sightings> getSightings() {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "SELECT * FROM sightings where animalId=:id";
//            return con.createQuery(sql)
//                    .addParameter("id", this.id)
//                    .executeAndFetch(Sightings.class);
//        }
//    }
}
