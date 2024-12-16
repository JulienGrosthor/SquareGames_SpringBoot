package com.example.demo.boardgamecatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/games")
    public String getGames() {
        return gameCatalog.getGameIdentifiers().toString();
    }
}
