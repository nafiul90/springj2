package com.nafiul.demo.services;


import com.nafiul.demo.model.User;
import com.nafiul.demo.repositorys.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }



}
