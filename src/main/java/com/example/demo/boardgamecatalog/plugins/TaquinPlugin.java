package com.example.demo.boardgamecatalog.plugins;

import com.example.demo.boardgamecatalog.GameService;
import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Locale;
import java.util.OptionalInt;

public class TaquinPlugin implements GamePlugin {

    @Override
    public String getName(Locale locale) {
        return "";
    }

    @Override
    public Game createGame(OptionalInt playerCount, OptionalInt boardSize) {
        return null;
    }
}
