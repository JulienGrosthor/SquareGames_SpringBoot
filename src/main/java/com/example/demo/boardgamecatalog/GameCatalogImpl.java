package com.example.demo.boardgamecatalog;

import com.example.demo.boardgamecatalog.plugins.GamePlugin;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {
    TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    TaquinGameFactory taquinGameFactory = new TaquinGameFactory();
    ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();

//    @Override
//    public List<String> getGameIdentifiers() {
//        return List.of(
//                ticTacToeGameFactory.getGameFactoryId(),
//                taquinGameFactory.getGameFactoryId(),
//                connectFourGameFactory.getGameFactoryId()
//        );
//    }

    @Override
    public Collection<GamePlugin> getPlugins() {
        return List.of();
    }

    @Override
    public GameFactory getGameFactory(String gameIdentifier) {
        return switch (gameIdentifier) {
            case "TicTacToe" -> ticTacToeGameFactory;
            case "Taquin" -> taquinGameFactory;
            case "ConnectFour" -> connectFourGameFactory;
            default -> null;
        };
    }
}
