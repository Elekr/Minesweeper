package com.tsi.tom.mineSweeper;

import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args){

        //Ask user for grid size input
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose your difficulty: 1:Easy 2:Medium 3:Hard");
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
            }
        }

        //Create an instance of the game
        Grid game = new Grid(gridSize, gridSize, totalMines);

        //Display the current state of the game
        System.out.println(game);
        //Player interaction (Choosing a tile)

        input.close();
    }



}
