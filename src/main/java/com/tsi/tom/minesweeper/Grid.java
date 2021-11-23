package com.tsi.tom.minesweeper;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;

public class Grid implements Game{

    public Grid(int gX, int gY) {
        this.gX = gX;
        this.gY = gY;
        this.gSize = gX * gY;
        this.gameBoard = new ArrayList<>();
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
        calculateMines(); //Get the total mines


        //Salt the mines into the board

        //Create a tile based on the inputs from the user
        for(int row = 0; row < gX; row++)
        {
            ArrayList<Tile> temp = new ArrayList<>(); //Create a list to push into the 2D list
            temp.clear(); //Remove old elements from the array
            for(int column = 0; column < gY; column++)
            {
                temp.add(new Clear());
            }
            gameBoard.add(row, temp);
        }
        addMines();
    }

    public void addMines()
    {
        Math.random();
        int saltMines = gTotalMines;

        while(saltMines != 0) //While there are still mines to be added to grid
        {
            int random_X = (int)Math.floor(Math.random()*((gX - 1)-0+1)+0); //Generate a random number within the grid bounds
            int random_Y = (int)Math.floor(Math.random()*((gY - 1)-0+1)+0);

            if(gameBoard.get(random_X).get(random_Y) != null) // if there is an object
            {
                if(gameBoard.get(random_X).get(random_Y).getTileType() != 0) // if the tile is not already a mine
                {
                    gameBoard.get(random_X).set(random_Y, new Mine()); //Make da mine
                    saltMines--;
                }
            }
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