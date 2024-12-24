package com.example.demo.boardgamecatalog.dao;

import org.apache.catalina.User;

import java.util.List;

public class InMemoryUserDAO implements UserDAO {

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
