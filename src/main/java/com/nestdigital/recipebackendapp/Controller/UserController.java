package com.nestdigital.recipebackendapp.Controller;

import com.nestdigital.recipebackendapp.Dao.UserDao;
import com.nestdigital.recipebackendapp.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signup",consumes = "application/json",produces = "application/json")
    public String Signup(@RequestBody UserModel user){
        System.out.println(user.toString());
        dao.save(user);
        return "{Status:'Success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<UserModel> Login(@RequestBody UserModel user){
        return (List<UserModel>) dao.SignIn(user.getEmail(), user.getPassword());
    }


}
