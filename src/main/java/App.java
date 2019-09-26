import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
//get Show Animal form
        get("/animal/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newAnimal-form.hbs");
        }, new HandlebarsTemplateEngine());
//        post: post new animal entered
        post("/animal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Animals newAnimal = new Animals(name);
            model.put("animal", newAnimal);
            newAnimal.save();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
//        Show all animals
        get("/allAnimals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = Animals.all();
            List<EndangeredAnimals> endangeredAnimals = EndangeredAnimals.all();
            model.put("endangeredAnimal", endangeredAnimals);
            model.put("animal", animals);
            return new ModelAndView(model, "allAnimals.hbs");
        }, new HandlebarsTemplateEngine());
//        Making a home pathway
        get("/",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine() );
        //get Show Endangered Animal form
        get("/EndangeredAnimal/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "EnAnimal-form.hbs");
        }, new HandlebarsTemplateEngine());
        //        post: post new Endangered animal entered
        post("/EndangeredAnimal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int health = Integer.parseInt(request.queryParams("health"));
            int age = Integer.parseInt(request.queryParams("age"));
            EndangeredAnimals newEndangeredAnimal = new EndangeredAnimals(name,health,age);
            model.put("endangeredAnimal", newEndangeredAnimal);
            newEndangeredAnimal.save();
            return new ModelAndView(model, "successE.hbs");
        }, new HandlebarsTemplateEngine());

        //get Show Sighting form

        get("/sight/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = Animals.all();
            List<EndangeredAnimals> endangeredAnimals = EndangeredAnimals.all();
            model.put("endangeredAnimal", endangeredAnimals);
            model.put("animal", animals);
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

//        post: post new Sighting entered
        post("/sight/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Sightings sighting = new Sightings(animalName,location,rangerName);
            model.put("sighting", sighting);
            sighting.save();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
//        Show all Sightings
        get("/allSightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> sightings = Sightings.all();
            model.put("sightings", sightings);
            return new ModelAndView(model, "allSightings.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
