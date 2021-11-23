package com.tsi.tom.minesweeper;

import java.util.Scanner;
import java.util.logging.Logger;

public class Minesweeper {

    private static final  Logger logger = Logger.getLogger(Minesweeper.class.getName());

    enum GameState
    {
        success,
        running,
        gameover,
        quit
    }

    public static void main(String[] args){

        GameState gameState = GameState.running;
        int gamestate = 2;
        Scanner input = new Scanner(System.in);
        logger.info("Please choose your difficulty: 1:Easy 2:Medium 3:Hard");
        String userChoice = input.next();

        Menu menu = new Menu(Integer.parseInt(userChoice));
        //Create an instance of the game
        Grid game = new Grid(menu.getGridSize(), menu.getGridSize(), (int)(Math.random() * 100));

        while(gameState == GameState.running) //While the game is not over
        {
            logger.info("output \n" + game);
            logger.info("Please select a tile");
            //User inputs tile
            int userX = Integer.parseInt(input.next());
            int userY = Integer.parseInt(input.next());

            gamestate = game.selectTile(userX, userY);

            switch(gamestate)
            {
                case 0: // QUITING THE GAME
                    //TODO: figure this out
                    logger.info("Game shutting down");
                    gameState = GameState.quit;
                    break;
                case 1: // GAME OVER
                    logger.info("uh oh, you hit a mine :)");
                    gameState = GameState.gameover;
                    break;
                case 2: // INVALID CHOICE
                    logger.info("Invalid choice, please select another tile");
                    break;
                case 3:
                    logger.info("Clear space!");
                    break;
                case 4:
                    logger.info("you won the game!");
                    gameState = GameState.success;
                default:
                    logger.info("how did you get here what");
            }
        }
    }
}
