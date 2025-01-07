package com.example.demo.boardgamecatalog.controller;

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

    public UserController(GameUserRepository gameUserRepository) {
        this.gameUserRepository = gameUserRepository;
    }

    @GetMapping("/")
    public List<GameUser> getAllUsers() {
        return gameUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public GameUser getUserById(@PathVariable Long id) {
        return gameUserRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public GameUser addUser(@RequestBody GameUser user) {
        return gameUserRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (gameUserRepository.existsById(id)) {
            gameUserRepository.deleteById(id);
            return "User with ID " + id + " deleted successfully.";
        } else {
            return "User with ID " + id + " not found.";
        }
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody GameUser updatedUser) {
        return gameUserRepository.findById(id).map(existingUser -> {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            gameUserRepository.save(existingUser);
            return "User with ID " + id + " updated successfully.";
        }).orElse("User with ID " + id + " not found.");
    }
}
