package com.example.demo.boardgamecatalog;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface GameCatalog {
    Collection<String> getGameIdentifiers();
    GameFactory getGameFactory(String gameIdentifier);
}