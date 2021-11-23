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
        this.currentMines = gTotalMines;
        createBoard();
    }

    ////Variables
    //Declaring the Size of the board
    private int gSize;
    private int gX;
    private int gY;
    private int gTotalMines;
    private int currentMines;


    class Boundaries
    {
        int min = 0;
        int max = 0;
    }

    //The Game board
    List<ArrayList<Tile>> gameBoard;

    ////Methods
    //Check if the tile is within the grid

    public boolean isValid(int uX, int uY, int type)
    {
        if(gameBoard.get(uX).get(uY).getTileType() == type && !gameBoard.get(uX).get(uY).isTileChecked())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Checks if the user tile is a Mine or a Clear
    public int selectTile(int userX, int userY)
    {
        //TODO:Validate user input but in the main
        //If the tile the user has selected is a clear tile
        if(isValid(userX, userY, 1)) //If it's a clear tile and it hasn't been checked yet
        {
            gameBoard.get(userX).get(userY).setTileChecked(true); //it's been checked yo
            int bombsSurrounding = checkSurroundingTiles(userX, userY);
            gameBoard.get(userX).get(userY).setCurrentSymbol((char)bombsSurrounding); //set the tile to be the number
            return 3; // Keep running
        }
        else if (gameBoard.get(userX).get(userY).getTileType() == 0) //If it's a mine
        {
            return 1; // Game over state
        }
        else if (currentMines == 0)
        {
            return 4; // Success!
        }
        else
        {
            return 2; // Invalid choice
        }
    }

    public void calculateBounds(int userValue, Boundaries coords)
    {
        if (userValue == 0) //If on the boundary of the grid
        {
            coords.min = userValue; //Don't decrease it cuz index
        }
        else if (userValue == gX)// if at the upper boundary
        {
            coords.max = userValue;
        }
        else
        {
            coords.min = (userValue - 1);
            coords.max = (userValue + 1);
        }
    }

    public int checkSurroundingTiles(int uX, int uY)
    {
        int count = 0; //Used to count the mines around the tile

        Boundaries x = new Boundaries();
        Boundaries y = new Boundaries();

        calculateBounds(uX, x); //Calculate the bounds for the x and y axis
        calculateBounds(uY, y);

        for(int row = x.min; row < x.max; row++) // go through a 3x3 grid around the selected tile
        {
            for(int column = y.min; column < y.max; column++)
            {
                if(gameBoard.get(row).get(column).getTileType() == 0) //if the tile is a bomb
                {
                    count++;
                }
            }
        }
        return count;
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
                //TODO: check whether the tile is checked and then draw based on that value
                bld.append(gameBoard.get(row).get(column).getCurrentSymbol() + " ");
            }
            bld.append("\n");
        }
        return bld.toString();
    }
}