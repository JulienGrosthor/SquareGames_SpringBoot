package com.example.demo.boardgamecatalog.dao;

import com.example.demo.boardgamecatalog.user.GameUser;
import org.apache.catalina.User;

import java.util.List;

public interface UserDAO {
    public List<GameUser> getAllUsers();
    public GameUser getUserById(int id);
    public void addUser(GameUser user);
    public void updateUser(GameUser user);
    public void deleteUser(int id);
}
