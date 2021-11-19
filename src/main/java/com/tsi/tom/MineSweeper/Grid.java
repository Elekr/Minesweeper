package com.tsi.tom.MineSweeper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grid implements Game{

    public Grid(int gX, int gY, int gTotalMines) {
        this.gX = gX;
        this.gY = gY;
        this.gSize = gX * gY;
        this.gTotalMines = gTotalMines;
        this.gameBoard = new ArrayList<ArrayList<Tile>>(gX);
        CreateBoard();
    }

    ////Variables
    //Declaring the Size of the board
    public int gSize;
    public int gX;
    public int gY;
    public int gTotalMines;

    //The Game board
    List<ArrayList<Tile>> gameBoard;

    ////Methods
    //Check if the tile is within the grid
    public boolean IsValid(){
        return true;
    }

    //Checks if the user tile is a Mine or a Clear
    public int SelectTile(int userX, int userY)
    {
        //If the tile the user has selected is a clear tile
        if(gameBoard.get(userX).get(userY).getTileType() == 1)
        {
            gameBoard.get(userX).get(userY).setTileChecked(true);

        }
        return 0;
    }

    public void CreateBoard() {
        //Random function
        //Check if the tile
        int randomValue = 0;
        int bombThreshold = 0;

        //Create a tile based on the inputs from the user
        for(int row = 0; row < gX; row++)
        {
            ArrayList<Tile> temp = new ArrayList<Tile>(); //Create a list to push into the 2D list
            temp.clear(); //Remove old elements from the array
            for(int column = 0; column < gY; column++)
            {

                //if the tType of the tile is 0 then it's a bomb, else it's clear (1)
                if(randomValue < bombThreshold)
                {

                    temp.add(new Clear(1));
                }
                else
                {
                    temp.add(new Mine(1));
                }
            }
            gameBoard.add(row, temp);
        }
    }

    public void DisplayBoard()
    {
        for(int row = 0; row < gX; row++)
        {
            for(int column = 0; column < gY; column++)
            {
               char output = gameBoard.get(row).get(column).getCurrentSymbol();
                System.out.print(output + " ");
            }
            System.out.println();
        }
    }
}