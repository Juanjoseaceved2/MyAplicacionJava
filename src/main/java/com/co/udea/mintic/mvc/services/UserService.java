package com.co.udea.mintic.mvc.services;

import com.co.udea.mintic.mvc.entities.User;
import com.co.udea.mintic.mvc.repository.UserRepositorio;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private UserRepositorio repository;


    public UserService(UserRepositorio repository) {
        this.repository = repository;
    }

    public User createUser (User newUser) {
        return this.repository.save(newUser);
    }

    public User findUserByEmail(String email){
        return this.repository.findByEmail(email);
    }

    public User generateOrCreateUser(Map<String, Object> UserData){
        String email = (String) UserData.get("email");
        User user = findUserByEmail(email);
        if (user == null) {
            String image = (String) UserData.get("picture");
            String auth0Id = (String) UserData.get("sub");
            User newUser = new User(email = email, image = image, auth0Id = auth0Id);
            return createUser(newUser);
        }
        return user;
    }
}
