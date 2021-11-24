package com.tsi.tom.test.minesweepertest;

import com.tsi.tom.minesweeper.Menu;

import com.tsi.tom.minesweeper.Minesweeper;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    private static final Logger logger = Logger.getLogger(MenuTest.class.getName());

    enum GameState
    {
        success,
        running,
        gameover,
        quit
    }

    @Test
    public void testMenuValues()
    {
        Menu menu;

        for(int i = 1; i <= 3; i++)
        {
            menu = new Menu(i);
            switch(menu.toString())
            {
                case "Easy":
                    assertEquals(menu.getGridSize(), 8, "grid size not set correctly");
                    assertEquals(menu.getGameDifficulty(), "Easy", "Game state");
                    break;
                case "Medium":
                    assertEquals(menu.getGridSize(), 16, "grid size not set correctly");
                    assertEquals(menu.getGameDifficulty(), "Medium", "Game state");
                    break;
                case "Hard":
                    assertEquals(menu.getGridSize(), 20, "grid size not set correctly");
                    assertEquals(menu.getGameDifficulty(), "Hard", "Game state");
                    break;
                default:
            }
        }
        menu = new Menu(1);
        Minesweeper.GameState testState = Minesweeper.GameState.running;
        assertEquals(testState = menu.gameLoop(0,0,testState), testState.running, "going to the correct state");
    }
}
