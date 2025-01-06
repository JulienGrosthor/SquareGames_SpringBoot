package com.example.demo.boardgamecatalog.controller;

import com.example.demo.boardgamecatalog.game.GameCreationParams;
import com.example.demo.boardgamecatalog.game.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

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
    public Game getGame(@PathVariable UUID gameId) {
        if (gameService.getGameById(gameId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
        return gameService.getGameById(gameId);
    }

    // Endpoint pour supprimer une partie spécifique (par ID)
    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable UUID gameId) {
        if (gameService.deleteGameById(gameId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
    }
}