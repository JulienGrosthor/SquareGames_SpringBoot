package com.example.demo.boardgamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    Game createGame(GameCreationParams params);
    List<Game> getAllGames();
    Game getGameById(int gameId);
    Game deleteGameById(int gameId);
}