package com.tsi.tom.minesweeper;

import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {

    @Override
    public String toString() {
        return gameDifficulty;
    }

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    public int getGridSize() {
        return gridSize;
    }

    public int getTotalMines() {
        return totalMines;
    }

    int gridSize;
    int totalMines;
    String gameDifficulty;

    public Menu(int input) {
        InitSize(input);
    }

    public String InitSize(int userInput)
    {
        //Ask user for grid size input

        switch(userInput)
        {
            case 1:
                gridSize = 8;
                totalMines = 10;
                gameDifficulty = "Easy";
                break;
            case 2:
                gridSize = 16;
                totalMines = 20;
                gameDifficulty = "Medium";
                break;
            case 3:
                gridSize = 20;
                totalMines = 30;
                gameDifficulty = "Hard";
                break;
            default:
                logger.info("Please choose an appropriate selection");
        }
        return "";
    }
}
