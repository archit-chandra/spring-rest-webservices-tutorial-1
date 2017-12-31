package com.gemalto.com.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component // to be managed by Spring, could also be @Repository
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;
    
    // will later be connected to db
    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }
    
    // return a specific user
    public User findOne(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    // return all users
    public List<User> findAll() {
        return users;
    }
    
    // create a user
    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
}
