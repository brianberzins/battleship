package org.murasaki.battleship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void boardSize() {
        Board board = new Board();
        assertEquals(8, board.coordinates.length);
        assertEquals(8, board.coordinates[0].length);
    }

    // all ships must be entirely on the board
    // they cannot overlap
    // each ship must be the right length, in an up/down direction only.

    @Test
    void allShipPresent() {
        Board board = new TestPlayer().placeShips(new Fleet());
        // assert that exactly the fleet is present
        assertEquals(new Fleet(), board.fleet);
    }


    // player return board needs to be the correct size

//    }
//
//    @Test
//    void shipsMissing() {
//
//    }
//
//
//    @Test
//    void allShipsInBounds() {
//
//    }
//
//    @Test
//    void shipsDoNotOverlap() {
//
//    }

}
