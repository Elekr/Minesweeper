package com.tsi.tom.MineSweeper;

public class Tile {
    public Tile(int tType) {
        this.tileType = tType;
        this.tileChecked = false;
        this.currentSymbol = '#';
    }

    public int getTileType() {
        return tileType;
    }

    public void setTileType(int tileType) {
        this.tileType = tileType;
    }

    public boolean isTileChecked() {
        return tileChecked;
    }

    public void setTileChecked(boolean tileChecked) {
        this.tileChecked = tileChecked;
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }

    public void setCurrentSymbol(char currentSymbol) {
        this.currentSymbol = currentSymbol;
    }

    private char currentSymbol;
    private int tileType;
    private boolean tileChecked;


}