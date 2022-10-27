package com.nestdigital.recipebackendapp.Controller;


import com.nestdigital.recipebackendapp.Dao.RecipeDao;
import com.nestdigital.recipebackendapp.Model.RecipeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

    @Autowired
    private RecipeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addRecipe",consumes = "application/json",produces = "application/json")
    public String AddRecipe(@RequestBody RecipeModel recipe)
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        recipe.setPosted_date(currentdate);
        System.out.println(recipe.toString());
        dao.save(recipe);
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Map<String,String>> ViewAll(){
        return (List<Map<String, String>>) dao.ViewAllPosts();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewSingle",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> SingleView(@RequestBody RecipeModel recipe){
        return (List<Map<String, String>>) dao.ViewSingle(recipe.getUser_id());
    }
}
