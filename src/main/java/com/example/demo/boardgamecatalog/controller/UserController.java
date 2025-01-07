package com.example.demo.boardgamecatalog.controller;

import com.example.demo.boardgamecatalog.dao.UserDAO;
import com.example.demo.boardgamecatalog.user.GameUser;
import com.example.demo.boardgamecatalog.user.GameUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final GameUserRepository gameUserRepository;

    @Autowired
//    private UserDAO userDAO;

    public UserController(GameUserRepository gameUserRepository) {
        this.gameUserRepository = gameUserRepository;
    }

    @GetMapping("/")
    public List<GameUser> getAllUsers() {
        return gameUserRepository.findAll();
    }
//
//    @GetMapping("/{id}")
//    public GameUser getUserById(@PathVariable int id) {
//        return userDAO.getUserById(id);
//    }
//
//    @PostMapping("")
//    public String addUser(@RequestBody GameUser user) {
//        userDAO.addUser(user);
//        return "User added successfully!";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable int id) {
//        userDAO.deleteUser(id);
//        return "User deleted (if existed).";
//    }
//
//    @PutMapping("/{id}")
//    public String updateUser(@PathVariable int id, @RequestBody GameUser user) {
//        GameUser updatedUser = new GameUser(id, user.getName(), user.getEmail());
//        userDAO.updateUser(updatedUser);
//        return "User updated.";
//    }
}
