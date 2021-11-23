package com.tsi.tom.test.minesweepertest;

import com.tsi.tom.minesweeper.Grid;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private static final Logger logger = Logger.getLogger(GridTest.class.getName());

    @Test
    public void testConstructor()
    {
        Grid testGrid = new Grid(20, 20, 20);

        assertEquals(testGrid.getgSize(), (20 * 20), "Grid size is based on values entered");
        assertEquals(testGrid.getgTotalMines(), (20 * 20) / 8, "Mines are total size / 8");
        assertEquals(testGrid.toString() instanceof String, true, "the board is displayed as a string");
    }

    @Test
    public void testFunctionality()
    {
        Grid testGrid = new Grid(20, 20, 20);

        assertEquals(testGrid.selectTile(0, 0), 3, "seeded so should always be a clear");
        assertEquals(testGrid.checkSurroundingTiles(0, 0), 0, "seeded so should always not have any bombs around it");
    }
}
