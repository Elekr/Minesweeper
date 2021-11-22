package com.tsi.tom.minesweeper;

import java.util.Scanner;
import java.util.logging.Logger;

public class Minesweeper {

    private static final  Logger logger = Logger.getLogger(Minesweeper.class.getName());

    public static void main(String[] args){

        Menu menu = new Menu();
        //Create an instance of the game
        Grid game = new Grid(menu.getGridSize(), menu.getGridSize(), menu.getTotalMines());


        //Display the current state of the game
        logger.info("output \n" + game );
        //Player interaction (Choosing a tile)


    }

}
