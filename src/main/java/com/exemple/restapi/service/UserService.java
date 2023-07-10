package com.exemple.restapi.service;

import com.exemple.restapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> userList;
    private List<User> totalList;


    public UserService() {
       userList = new ArrayList<>();
       totalList = new ArrayList<>();
       User user1 = new User(1, "Michel", 27, "michel@gmail.com");
       User user2 = new User(2, "Bernardo", 28, "bernardo@gmail.com");
       User user3 = new User(3, "Silveira", 29, "silveira@gmail.com");

       userList.addAll(Arrays.asList(user1,user2,user3));
    }

    public Optional<User> getUserId(Integer id) {
        Optional userId = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()){
                userId = Optional.of(user);
                return userId;
            }
        }
        return userId;
    }

    public Optional<User> getUserName(String name) {
        Optional userName = Optional.empty();
        for (User user: userList) {
            if(Objects.equals(name, user.getName())) {
                userName = Optional.of(user);
                return userName;
            }
        }
        return  userName;
    }


}
