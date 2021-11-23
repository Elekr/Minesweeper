package com.tsi.tom.test.minesweepertest;

import com.tsi.tom.minesweeper.Menu;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    private static final Logger logger = Logger.getLogger(MenuTest.class.getName());

    @Test
    public void testMenuValues()
    {
        Menu menu = new Menu(1);

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
