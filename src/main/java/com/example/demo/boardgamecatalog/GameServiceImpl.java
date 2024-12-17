package com.example.demo.boardgamecatalog;


import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameCatalog gameCatalog;
    private final List<Game> games = new ArrayList<>();

    @Override
    public Game createGame(GameCreationParams params) {
        GameFactory gameFactory = gameCatalog.getGameFactory(params.getGameType());
        if (gameFactory == null) {
            throw new IllegalArgumentException("Invalid game type: " + params.getGameType());
        }
        Game game = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
        games.add(game);
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    @Override
    public Game getGameById(int gameId) {
        if (gameId < 0 || gameId >= games.size()) {
            throw new IllegalArgumentException("Invalid game ID: " + gameId);
        }
        return games.get(gameId);
    }

    @Override
    public String deleteGameById(int gameId) {
        if (gameId < 0 || gameId >= games.size()) {
            throw new IllegalArgumentException("Invalid game ID: " + gameId);
        }
        return "Game removed: " + games.remove(gameId).toString();
    }
}
