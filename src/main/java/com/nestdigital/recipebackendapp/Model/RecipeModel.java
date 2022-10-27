package com.nestdigital.recipebackendapp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class RecipeModel {

    @Id
    @GeneratedValue

    private int id;
    private int user_id;
    private String dish_name;
    private String ingredients;
    private String posted_date;

    public RecipeModel() {
    }

    public RecipeModel(int id, int user_id, String dish_name, String ingredients, String posted_date) {
        this.id = id;
        this.user_id = user_id;
        this.dish_name = dish_name;
        this.ingredients = ingredients;
        this.posted_date = posted_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }
}
