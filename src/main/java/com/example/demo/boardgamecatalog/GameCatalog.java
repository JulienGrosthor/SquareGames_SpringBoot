package com.example.demo.boardgamecatalog;

import com.example.demo.boardgamecatalog.plugins.GamePlugin;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface GameCatalog {
    Collection<GamePlugin> getPlugins();
    GameFactory getGameFactory(String gameIdentifier);
}