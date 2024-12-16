package com.example.demo.boardgamecatalog;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {
    TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();

    @Override
    public List<String> getGameIdentifiers() {
        return List.of(ticTacToeGameFactory.getGameFactoryId());
    }
}
