package com.tsi.tom.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Grid implements Game{



    public Grid(int gX, int gY, int gTotalMines) {
        this.gX = gX;
        this.gY = gY;
        this.gSize = gX * gY;
        this.gTotalMines = gTotalMines;
        this.gameBoard = new ArrayList<>(gX);
        createBoard();
    }

    ////Variables
    //Declaring the Size of the board
    private int gSize;
    private int gX;
    private int gY;
    private int gTotalMines;

    //The Game board
    List<ArrayList<Tile>> gameBoard;

    ////Methods
    //Check if the tile is within the grid
    public boolean isValid(){
        return true;
    }

    //Checks if the user tile is a Mine or a Clear
    public int selectTile(int userX, int userY)
    {
        //If the tile the user has selected is a clear tile
        if(gameBoard.get(userX).get(userY).getTileType() == 1)
        {
            gameBoard.get(userX).get(userY).setTileChecked(true);

        }
        return 0;
    }

    public void createBoard() {
        //Random function
        //Check if the tile
        int randomValue = 0;
        int bombThreshold = 0;
        calculateMines();

        //Create a tile based on the inputs from the user
        for(int row = 0; row < gX; row++)
        {
            ArrayList<Tile> temp = new ArrayList<>(); //Create a list to push into the 2D list
            temp.clear(); //Remove old elements from the array
            for(int column = 0; column < gY; column++)
            {

                //if the tType of the tile is 0 then it's a bomb, else it's clear (1)
                if(randomValue < bombThreshold)
                {

                    temp.add(new Clear());
                }
                else
                {
                    temp.add(new Mine());
                }
            }
            gameBoard.add(row, temp);
        }
    }

    public void calculateMines()
    {
        gTotalMines = gSize / 8;
    }

    @Override
    public String toString() {

        StringBuilder bld = new StringBuilder();
        for(int row = 0; row < gX; row++)
        {
            for(int column = 0; column < gY; column++)
            {
                bld.append(gameBoard.get(row).get(column).getCurrentSymbol() + " ");
            }
            bld.append("\n");
        }
        return bld.toString();
    }
}