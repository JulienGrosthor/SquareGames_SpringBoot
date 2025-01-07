package com.example.demo.boardgamecatalog.user;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GameUserRepository extends JpaRepository<GameUser, Long> {
    List<GameUser> findAll();
    List<GameUser> findByName(String name);
    List<GameUser> findByEmail(String email);
    GameUser findByNameOrEmail(@NotNull String name, @NotNull String email);
}
