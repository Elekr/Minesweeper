package com.tsi.tom.MineSweeper;

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
                    gridSize = 5;
                case 2:
                    gridSize = 10;
                case 3:
                    gridSize = 20;
            }
        }

        //Create an instance of the game
        Grid game = new Grid(gridSize, gridSize, totalMines);

        input.close();
    }



}
