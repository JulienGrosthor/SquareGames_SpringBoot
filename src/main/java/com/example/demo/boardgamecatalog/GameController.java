package com.example.demo.boardgamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint pour créer une nouvelle partie
    @PostMapping("/new")
    public Object createGame(@RequestBody GameCreationParams params) {
        return gameService.createGame(params);
    }

    // Endpoint pour lister toutes les parties
    @GetMapping("/all")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    // Endpoint pour récupérer l'état d'une partie spécifique (par ID)
    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable int gameId) {
        return gameService.getGameById(gameId);
    }

    // Endpoint pour supprimer une partie spécifique (par ID)
    @DeleteMapping("/{gameId}")
    public String deleteGame(@PathVariable int gameId) {
        return gameService.deleteGameById(gameId);
    }
}