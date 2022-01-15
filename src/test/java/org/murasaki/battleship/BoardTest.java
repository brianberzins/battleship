package org.murasaki.battleship;

import org.approvaltests.awt.AwtApprovals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.murasaki.battleship.ShotResultType.*;

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
        board.placeShip(Ship.SUBMARINE, new Coordinate(7, 4), Orientation.VERTICAL);
        AwtApprovals.verify(board);
    }

    @Test
    void fireOnShips() {
        GuiBoard board = new GuiBoard();
        board.placeShip(Ship.AIRCRAFT_CARRIER, new Coordinate(2, 3), Orientation.HORIZONTAL);
        board.placeShip(Ship.SUBMARINE, new Coordinate(3, 5), Orientation.VERTICAL);
        assertEquals(new ShotResult(MISS, null), board.fireOn(new Coordinate(6,7)));
        assertEquals(new ShotResult(HIT, Ship.AIRCRAFT_CARRIER), board.fireOn(new Coordinate(4,3)));
        AwtApprovals.verify(board);
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
