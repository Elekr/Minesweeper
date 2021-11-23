package com.tsi.tom.minesweeper;

public abstract class Tile {
    //Constructor
    public Tile() {
        this.tileChecked = false;
        this.currentSymbol = ' ';
    }

    //Methods
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

    //Variables
    private char currentSymbol;
    protected int tileType;
    private boolean tileChecked;
}