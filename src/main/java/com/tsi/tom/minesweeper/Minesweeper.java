package com.tsi.tom.minesweeper;

import java.util.Scanner;
import java.util.logging.Logger;

public class Minesweeper {

    private final static Logger logger = Logger.getLogger(Minesweeper.class.getName());

    public static void main(String[] args){

        //Ask user for grid size input
        Scanner input = new Scanner(System.in);
        logger.info("Please choose your difficulty: 1:Easy 2:Medium 3:Hard");
        int userChoice = input.nextInt();
        int gridSize = 0;
        int totalMines = 0;
        while(gridSize == 0)
        {
            switch(userChoice)
            {
                case 1:
                    gridSize = 8;
                    break;
                case 2:
                    gridSize = 16;
                    break;
                case 3:
                    gridSize = 20;
                    break;
                default:
                    logger.info("Please choose an appropriate selection");
            }
        }

        //Create an instance of the game
        Grid game = new Grid(gridSize, gridSize, totalMines);

        //Display the current state of the game
        logger.info("output \n" +game);
        //Player interaction (Choosing a tile)

        input.close();
    }



}
