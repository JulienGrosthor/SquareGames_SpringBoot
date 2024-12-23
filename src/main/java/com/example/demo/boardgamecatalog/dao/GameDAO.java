package com.example.demo.boardgamecatalog.dao;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.List;
import java.util.UUID;

// Interface DAO pour gérer les objets Game
public interface GameDAO {
    // Crée un nouvel objet Game
    Game create(Game game);

    // Récupère un objet Game par son ID
    Game read(UUID id);

    // Met à jour un objet Game existant
    Game update(Game game);

    // Supprime un objet Game par son ID
    boolean delete(UUID id);

    // Récupère tous les objets Game
    List<Game> getAll();
}
