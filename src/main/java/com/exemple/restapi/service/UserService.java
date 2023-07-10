package com.exemple.restapi.service;

import com.exemple.restapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
       userList = new ArrayList<>();
       User user1 = new User(1, "Michel", 27, "michel@gmail.com");
       User user2 = new User(2, "Bernardo", 28, "bernardo@gmail.com");
       User user3 = new User(3, "Silveira", 29, "silveira@gmail.com");
       User user4 = new User(4, "Michel", 30, "michelbs@gmail.com");

       userList.addAll(Arrays.asList(user1,user2,user3,user4));
    }

    public List<User> getAllUser(){
        return  userList;
    }

    public Optional<User> getUserId(Integer id) {
        Optional result = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()){
                result = Optional.of(user);
                return result;
            }
        }
        return result;
    }

    public Optional<User> getUserName(String name) {
        Optional result = Optional.empty();
        for (User user: userList) {
            if(Objects.equals(name, user.getName())) {
                result = Optional.of(user);
                return result;
            }
        }
        return  result;
    }

    public Optional<User> getUserForNameAndEmail(String name, String  email) {
        Optional result = Optional.empty();
        for (User user: userList) {
            if(Objects.equals(name, user.getName()) && Objects.equals(email, user.getEmail())) {
                result = Optional.of(user);
                return result;
            }
        }
        return result;
    }

}
