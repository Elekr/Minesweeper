package com.tsi.tom.test.minesweepertest;

import com.tsi.tom.minesweeper.Clear;
import com.tsi.tom.minesweeper.Mine;
import com.tsi.tom.minesweeper.Tile;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TileTest {

    private static final Logger logger = Logger.getLogger(TileTest.class.getName());

    @Test
    public void testClassVariables()
    {
        //Test Array
        Tile[] tiles = new Tile[2];
        tiles[0] = new Clear();
        tiles[1] = new Mine();

        //Check that the default values are correct for the class
        assertEquals(tiles[0].getTileType(), 1, "Clear tiles must always be declared as 1");
        assertEquals(tiles[1].getTileType(), 0, "Mines must always be declared as 0");

        assertEquals(tiles[0].getCurrentSymbol(), '#', "Clear tile icon set correctly");
        assertEquals(tiles[1].getCurrentSymbol(), '*', "Mine displayed correctly");

        assertEquals(tiles[0].isTileChecked(), false, "Check that the initial state of the tile is unchecked");
        assertEquals(tiles[1].isTileChecked(), false, "Check that the initial state of the tile is unchecked");

        //Setting values
        tiles[0].setTileType(3);
        tiles[1].setTileType(-3);

        tiles[0].setCurrentSymbol('@');
        tiles[1].setCurrentSymbol('-');

        tiles[0].setTileChecked(true);
        tiles[1].setTileChecked(true);

        //Check that the updated values are being correctly set for the class
        assertEquals(tiles[0].getTileType(), 3, "Updated value");
        assertEquals(tiles[1].getTileType(), -3, "Updated value");

        assertEquals(tiles[0].getCurrentSymbol(), '@', "Updated value");
        assertEquals(tiles[1].getCurrentSymbol(), '-', "Updated value");

        assertEquals(tiles[0].isTileChecked(), true, "Updated value");
        assertEquals(tiles[1].isTileChecked(), true, "Updated value");

    }

}
