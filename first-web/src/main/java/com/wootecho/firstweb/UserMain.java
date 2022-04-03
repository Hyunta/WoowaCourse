package com.wootecho.firstweb;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class UserMain {
    public static void main(String[] args) {
        staticFiles.location("/static");

        List<User> users = new ArrayList<>();
        post("/users", (req, res) -> {
            User user = new User();
            user.setName(req.queryParams("name"));
            user.setAge(req.queryParams("age"));
            users.add(user);
            Map<String, Object> model = new HashMap<>();
            model.put("users", users);

            return render(model, "result.html");
        });

    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
