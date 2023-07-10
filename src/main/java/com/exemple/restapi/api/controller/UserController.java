package com.exemple.restapi.api.controller;

import com.exemple.restapi.api.model.User;
import com.exemple.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/userId")
    public User getUserId(@RequestParam Integer id) {
        Optional user = userService.getUserId(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return  null;
    }

    @GetMapping("/userName")
    public User getUserName(@RequestParam String name) {
        Optional user = userService.getUserName(name);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }

    @GetMapping("/userNameAndEmail")
    public User getUserNameAndEmail(@RequestParam String name, String email) {
        Optional user = userService.getUserForNameAndEmail(name, email);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }
}
