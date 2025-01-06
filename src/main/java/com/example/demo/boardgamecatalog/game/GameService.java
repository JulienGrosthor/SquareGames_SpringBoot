package com.example.demo.boardgamecatalog.game;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GameService {
    Game createGame(GameCreationParams params);
    List<Game> getAllGames();
    Game getGameById(UUID gameId);
    Game deleteGameById(UUID gameId);
}