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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args){

        GameState gameState = GameState.running;
        int gamestate = 2;

        Scanner input = new Scanner(System.in);
        logger.info("Please choose your difficulty: 1:Easy 2:Medium 3:Hard");
        String userChoice = input.next();

        Menu menu = new Menu(Integer.parseInt(userChoice));
        //Create an instance of the game
        Grid game = new Grid(menu.getGridSize(), menu.getGridSize());


        while(gameState == GameState.running) //While the game is not over
        {
            logger.info("output \n" + game);
            logger.info("Please select a tile");

            userChoice = input.next();
            if(userChoice.equals('q'))
            {
                gamestate = 0;
            }
            //TODO:if user input is q then set gamestate to 0
            switch(gamestate)
            {
                case 0: // QUITING THE GAME
                    logger.info("Game shutting down");
                    gameState = GameState.quit;
                    break;
                case 1: // GAME OVER
                    logger.info("uh oh, you hit a mine :)");
                    gameState = GameState.gameover;
                    break;
                case 2: // INVALID CHOICE
                    logger.info("Invalid choice, please select another tile");
                    clearScreen();
                    break;
                case 3:
                    logger.info("Clear space!");
                    clearScreen();
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
