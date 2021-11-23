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
    int gamestate = 2;

    //Create an instance of the game
    Grid game;

    public Menu(int input)
    {
        InitSize(input);
        game = new Grid(gridSize, gridSize, (int)(Math.random() * 100));
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

    public Minesweeper.GameState startGame(int x, int y, Minesweeper.GameState currentState)
    {
        gamestate = game.selectTile(x, y);

        switch(gamestate)
        {
            case 0: // QUITING THE GAME
                //TODO: figure this out
                logger.info("Game shutting down");
                currentState = Minesweeper.GameState.quit;
                break;
            case 1: // GAME OVER
                logger.info("uh oh, you hit a mine :)");
                currentState = Minesweeper.GameState.gameover;
                break;
            case 2: // INVALID CHOICE
                logger.info("Invalid choice, please select another tile");
                break;
            case 3:
                logger.info("Clear space!");
                break;
            case 4:
                logger.info("you won the game!");
                currentState = Minesweeper.GameState.success;
            default:
                logger.info("how did you get here what");
        }
        return currentState;
    }

    public void displayboard()
    {
        logger.info("\n" + game);
        logger.info("Please select a tile");
    }

}
