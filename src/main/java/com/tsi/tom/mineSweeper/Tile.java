package com.tsi.tom.mineSweeper;

public class Tile {
    public Tile() {
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
    protected int tileType;
    private boolean tileChecked;


}