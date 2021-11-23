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

        //Setup
        GameState gameState = GameState.running;
        Scanner input = new Scanner(System.in);
        logger.info("Please choose your difficulty: 1:Easy 2:Medium 3:Hard");
        String userChoice = input.next();

        //Initialise
        Menu menu = new Menu(Integer.parseInt(userChoice));

        //Game loop
        while(gameState == GameState.running) //While the game is not over
        {
            menu.displayboard();
            //User inputs tile
            logger.info("Enter X coord");
            int userX = Integer.parseInt(input.next());
            logger.info("Enter Y coord");
            int userY = Integer.parseInt(input.next());
            gameState = menu.gameLoop(userX, userY, gameState);
        }
    }
}
