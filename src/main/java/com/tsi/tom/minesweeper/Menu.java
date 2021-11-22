package com.tsi.tom.minesweeper;

import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    public int getGridSize() {
        return gridSize;
    }

    public int getTotalMines() {
        return totalMines;
    }

    int gridSize;
    int totalMines;

    public Menu() {
        InitSize();
    }

    public String InitSize()
    {
        //Ask user for grid size input
        Scanner input = new Scanner(System.in);
        logger.info("Please choose your difficulty: 1:Easy 2:Medium 3:Hard");
        int userChoice = input.nextInt();
        switch(userChoice)
        {
            case 1:
                gridSize = 8;
                totalMines = 10;
                break;
            case 2:
                gridSize = 16;
                totalMines = 20;
                break;
            case 3:
                gridSize = 20;
                totalMines = 30;
                break;
            default:
                logger.info("Please choose an appropriate selection");
        }
        return "";
    }
}
