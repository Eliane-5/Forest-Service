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
            int id = Integer.parseInt(request.queryParams("id"));
            Animals newAnimal = new Animals(name);
            model.put("animal", newAnimal);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
//        Show all animals on home page
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = Animals.all();
            model.put("animals", animals);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
