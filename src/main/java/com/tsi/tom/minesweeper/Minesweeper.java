package com.tsi.tom.minesweeper;

import java.util.Scanner;
import java.util.logging.Logger;

public class Minesweeper {

    private static final  Logger logger = Logger.getLogger(Minesweeper.class.getName());

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        logger.info("Please choose your difficulty: 1:Easy 2:Medium 3:Hard");
        int userChoice = input.nextInt();
        Menu menu = new Menu(userChoice);
        //Create an instance of the game
        Grid game = new Grid(menu.getGridSize(), menu.getGridSize());



        //Display the current state of the game
        logger.info("output \n" + game );
        //Player interaction (Choosing a tile)


    }

}
