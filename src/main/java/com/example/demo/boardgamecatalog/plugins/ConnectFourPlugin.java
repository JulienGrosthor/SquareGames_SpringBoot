package com.example.demo.boardgamecatalog.plugins;

import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.OptionalInt;

@Component
public class ConnectFourPlugin implements GamePlugin{

    @Override
    public String getName(Locale locale) {
        return "";
    }

    @Override
    public Game createGame(OptionalInt playerCount, OptionalInt boardSize) {
        return null;
    }
}
