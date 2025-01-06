package com.example.demo.boardgamecatalog.controller;

import com.example.demo.boardgamecatalog.dao.UserDAO;
import com.example.demo.boardgamecatalog.user.GameUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("")
    public List<GameUser> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @GetMapping("/{id}")
    public GameUser getUserById(@PathVariable int id) {
        return userDAO.getUserById(id);
    }

    @PostMapping("")
    public String addUser(@RequestBody GameUser user) {
        userDAO.addUser(user);
        return "User added successfully!";
    }
}
