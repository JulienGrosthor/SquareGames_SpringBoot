package com.example.demo.boardgamecatalog.game;

public class GameCreationParams {
    private final String gameType; // Type du jeu
    private final int playerCount; // Nombre de joueurs
    private final int boardSize;   // Taille du plateau

    // Constructeur
    public GameCreationParams(String gameType, int playerCount, int boardSize) {
        this.gameType = gameType;
        this.playerCount = playerCount;
        this.boardSize = boardSize;
    }

    // Getters et Setters
    public String getGameType() {
        return gameType;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
