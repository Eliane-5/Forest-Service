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
//get Show Animal form after sighting
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
//        Show all animals on home page
        get("/allAnimals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = Animals.all();
            model.put("animal", animals);
            return new ModelAndView(model, "allAnimals.hbs");
        }, new HandlebarsTemplateEngine());
//        Making a home pathway
        get("/",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine() );
    }
}
