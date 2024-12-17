package com.example.demo.boardgamecatalog;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameCatalog gameCatalog;
    private GameFactory gameFactory;
    private final List<Game> games = new ArrayList<>();

    // Endpoint pour créer une nouvelle partie
    @PostMapping("/new")
    public Object createGame(@RequestBody GameCreationParams params) {
        int playerCount = params.getPlayerCount();
        int boardSize = params.getBoardSize();

        gameFactory = gameCatalog.getGameFactory(params.getGameType());

        Game game = gameFactory.createGame(playerCount, boardSize);
        games.add(game);
        return game;
    }

    // Endpoint pour lister toutes les parties
    @GetMapping("/all")
    public List<Game> getAllGames() {
        return games;
    }

    // Endpoint pour récupérer l'état d'une partie spécifique
    @GetMapping("/{gameId}")
    public String getGame(@PathVariable int gameId) {
        if (gameId < 0 || gameId >= games.size()) {
            return "No game found with game ID : " + gameId;
        }
        return games.get(gameId).toString();
    }

    @DeleteMapping("/{gameId}")
    public String deleteGame(@PathVariable int gameId) {
        if (gameId < 0 || gameId >= games.size()) {
            return "No game found with game ID : " + gameId;
        }
        return games.remove(gameId).toString();
    }
}