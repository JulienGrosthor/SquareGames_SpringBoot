package com.example.demo.boardgamecatalog.controller;

import com.example.demo.boardgamecatalog.game.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/games/catalog")
    public Collection<?> getGames(Locale locale) {
        return this.gameCatalog.getPlugins().stream()
                .map(plugin-> Map.of(
                        "id","",
                        "name",plugin.getName(locale)
                ))
                .toList();
    }
}