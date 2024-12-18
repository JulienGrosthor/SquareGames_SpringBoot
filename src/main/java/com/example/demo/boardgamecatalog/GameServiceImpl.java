package com.example.demo.boardgamecatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameCatalog gameCatalog;

    // Utilisation d'un Map pour stocker les jeux avec leurs UUID comme clé
    private final Map<UUID, Game> games = new HashMap<>();

    @Override
    public Game createGame(GameCreationParams params) {
        GameFactory gameFactory = gameCatalog.getGameFactory(params.getGameType());
        if (gameFactory == null) {
            throw new IllegalArgumentException("Invalid game type: " + params.getGameType());
        }

        // Création du jeu
        Game game = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());

        // Ajout du jeu au Map avec son UUID
        games.put(game.getId(), game);

        return game;
    }

    @Override
    public List<Game> getAllGames() {
        // Retourne toutes les valeurs (jeux) du Map
        return new ArrayList<>(games.values());
    }

    @Override
    public Game getGameById(UUID gameId) {
        // Retourne le jeu correspondant au UUID, ou null si non trouvé
        return games.get(gameId);
    }

    @Override
    public Game deleteGameById(UUID gameId) {
        // Supprime le jeu du Map et le retourne
        return games.remove(gameId);
    }
}
