package com.example.demo.boardgamecatalog.dao;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.*;

// Implémentation concrète de GameDAO utilisant une collection en mémoire
public class InMemoryGameDAO implements GameDAO {
    private final Map<UUID, Game> games = new HashMap<>();

    @Override
    public Game create(Game game) {
        // Vérifie si un jeu avec le même ID existe déjà
        if (games.containsKey(game.getId())) {
            throw new IllegalArgumentException("Un jeu avec cet ID existe déjà.");
        }
        // Ajoute le jeu à la collection en mémoire
        games.put(game.getId(), game);
        return game;
    }


    @Override
    public Game read(UUID id) {
        return games.get(id);
    }

    @Override
    public Game update(Game game) {
        if (!games.containsKey(game.getId())) {
            throw new NoSuchElementException("Game not found with ID: " + game.getId());
        }
        games.put(game.getId(), game);
        return game;
    }

    @Override
    public boolean delete(UUID id) {
        return games.remove(id) != null;
    }

    @Override
    public List<Game> getAll() {
        return new ArrayList<>(games.values());
    }
}
