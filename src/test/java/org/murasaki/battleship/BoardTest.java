package org.murasaki.battleship;

import org.approvaltests.awt.AwtApprovals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void boardSize() {
        Board board = new Board();
        assertEquals(10, board.coordinates.length);
        assertEquals(10, board.coordinates[0].length);
    }

    // all ships must be entirely on the board
    // they cannot overlap
    // each ship must be the right length, in an up/down direction only.

    @Test
    void emptyBoard() {
        Board board = new Board();
        Arrays.stream(board.coordinates).flatMap(Arrays::stream).forEach(Assertions::assertNotNull);
        Arrays.stream(board.coordinates).flatMap(Arrays::stream).forEach(coordinate -> assertNull(board.getShipAt(coordinate)));
    }

    @Test
    void placeShips() {
        GuiBoard board = new GuiBoard();
        board.placeShip(Ship.AIRCRAFT_CARRIER, new Coordinate(1, 2), Orientation.HORIZONTAL);
        AwtApprovals.verify(board);
    }

    @Test
    void placeShipHorizontally() {
        Board board = new Board();
        assertTrue(board.placeShip(Ship.AIRCRAFT_CARRIER, new Coordinate(0, 0), Orientation.HORIZONTAL));
        assertTrue(board.fleet.contains(Ship.AIRCRAFT_CARRIER));
        Arrays.stream(board.coordinates).flatMap(Arrays::stream).forEach(coordinate -> {
            if (0 <= coordinate.x && coordinate.x <= 4 && coordinate.y == 0) {
                assertEquals(Ship.AIRCRAFT_CARRIER, board.getShipAt(coordinate));
            } else {
                assertNull(board.getShipAt(coordinate));
            }
        });
    }

    @Test
    void placeShipVertically() {
        Board board = new Board();
        assertTrue(board.placeShip(Ship.AIRCRAFT_CARRIER, new Coordinate(0,0), Orientation.VERTICAL));
        assertTrue(board.fleet.contains(Ship.AIRCRAFT_CARRIER));
        Arrays.stream(board.coordinates).flatMap(Arrays::stream).forEach(coordinate -> {
            if (0 <= coordinate.y && coordinate.y <= 4 && coordinate.x == 0) {
                assertEquals(Ship.AIRCRAFT_CARRIER, board.getShipAt(coordinate));
            } else {
                assertNull(board.getShipAt(coordinate));
            }
        });
    }


//    @Test
//    void allShipPresent() {
//        Board board = new Board();
//        board.placeShip(Ship.AIRCRAFT_CARRIER, new Coordinate(0, 0), Orientation.HORIZONTAL);
//        board.placeShip(Ship.BATTLESHIP, new Coordinate(0, 0), Orientation.HORIZONTAL);
//        board.placeShip(Ship.CRUISER, new Coordinate(0, 0), Orientation.HORIZONTAL);
//        board.placeShip(Ship.SUBMARINE, new Coordinate(0, 0), Orientation.HORIZONTAL);
//        board.placeShip(Ship.DESTROYER, new Coordinate(0, 0), Orientation.HORIZONTAL);
//
//        // assert that exactly the fleet is present
//        assertEquals(new Fleet(), board.fleet);
//    }


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
