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

    public String getGameDifficulty() {
        return gameDifficulty;
    }

    private int gridSize;

    private String gameDifficulty;

    public Menu(int input) {
        InitSize(input);
    }

    public void InitSize(int userInput)
    {
        switch(userInput)
        {
            case 1:
                gridSize = 8;
                gameDifficulty = "Easy";
                break;
            case 2:
                gridSize = 16;
                gameDifficulty = "Medium";
                break;
            case 3:
                gridSize = 20;
                gameDifficulty = "Hard";
                break;
            default:
                logger.info("Please choose an appropriate selection");
        }
    }
}
