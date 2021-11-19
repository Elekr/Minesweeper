package com.tsi.tom.MineSweeper;

import java.util.ArrayList;
import java.util.List;

public class Grid implements Game{

    public Grid(int gX, int gY, int gTotalMines) {
        this.gX = gX;
        this.gY = gY;
        this.gSize = gX * gY;
        this.gTotalMines = gTotalMines;
        this.gameBoard = new ArrayList<ArrayList<Tile>>();
        CreateBoard();
    }

    ////Variables
    //Declaring the Size of the board
    public int gSize;
    public int gX;
    public int gY;
    public int gTotalMines;

    //The Game board
    ArrayList<ArrayList<Tile>> gameBoard;

    ////Methods
    //Check if the tile is within the grid
    public boolean IsValid(){
        return true;
    }

    public void CreateBoard() {
        //Random function
        //Check if the tile

        int randomValue = 0;
        int bombThreshold = 0;

        //Create a tile based on the inputs from the user
        for(int row = 0; row < gX; row++)
        {
            for(int column = 0; column < gY; column++)
            {
                if(randomValue < bombThreshold)
                {
                    gameBoard.get(row).add(new Mine());
                }
                else
                {
                    gameBoard.get(row).add(new Clear());
                }
            }
        }


    }

}
