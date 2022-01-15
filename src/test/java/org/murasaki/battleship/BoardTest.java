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
        assertEquals(new ShotResult(MISSED, null), board.fireOn(new Coordinate(6,7)));
        assertEquals(new ShotResult(HIT, Ship.AIRCRAFT_CARRIER), board.fireOn(new Coordinate(4,3)));
        AwtApprovals.verify(board);
    }

    @Test
    void sinkOnShips() {
        GuiBoard board = new GuiBoard();
        board.placeShip(Ship.DESTROYER, new Coordinate(3, 4), Orientation.HORIZONTAL);
        assertEquals(new ShotResult(HIT, Ship.DESTROYER), board.fireOn(new Coordinate(3,4)));
        assertEquals(new ShotResult(SANK, Ship.DESTROYER), board.fireOn(new Coordinate(4,4)));
    }

}
