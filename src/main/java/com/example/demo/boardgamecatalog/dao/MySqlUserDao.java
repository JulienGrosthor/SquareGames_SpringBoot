package com.example.demo.boardgamecatalog.dao;

import com.example.demo.boardgamecatalog.user.GameUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component

public class MySqlUserDao implements UserDAO {

    @Override
    public List<GameUser> getAllUsers() {
        List<GameUser> users = new ArrayList<>();
        String query = "SELECT * FROM USERS";

        try (Connection connection = DbAccess.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                GameUser user = new GameUser();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public GameUser getUserById(int id) {
        String query = "SELECT id, name, email FROM USERS WHERE id = ?";
        try (Connection connection = DbAccess.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultSet.getInt("id");
                resultSet.getString("name");
                resultSet.getString("email");

            return new GameUser(id,resultSet.getString("name"),resultSet.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
