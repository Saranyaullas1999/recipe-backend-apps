package com.nestdigital.recipebackendapp.Dao;

import com.nestdigital.recipebackendapp.Model.RecipeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface RecipeDao extends CrudRepository<RecipeModel,Integer> {

    @Query(value = "SELECT  r.id,r.`dish_name`, r.`ingredients`, r.`posted_date`,u.name,r.user_id FROM `recipe` r JOIN users u ON u.id=r.user_id",nativeQuery = true)
    List<Map<String,String>>ViewAllPosts();

    @Query(value = "SELECT  r.id,r.`dish_name`, r.`ingredients`, r.`posted_date`,u.name,r.user_id FROM `recipe` r JOIN users u ON u.id=r.user_id WHERE r.user_id= :user_id",nativeQuery = true)
    List<Map<String,String>> ViewSingle(Integer user_id);
}
