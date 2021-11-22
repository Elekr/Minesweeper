package com.tsi.tom.minesweepertest;

import com.tsi.tom.minesweeper.Menu;
import com.tsi.tom.minesweeper.Minesweeper;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    private static final Logger logger = Logger.getLogger(Minesweeper.class.getName());
    @Test
    public void Menutest()
    {
        Menu menu = new Menu(4);

        switch(menu.toString())
        {
            case "Easy":
                assertEquals(menu.getGridSize(), 8, "grid size not set correctly");
                break;
            case "Medium":
                assertEquals(menu.getGridSize(), 16, "grid size not set correctly");
                break;
            case "Hard":
                assertEquals(menu.getGridSize(), 20, "grid size not set correctly");
                break;
            default:
        }
    }
}
