package org.murasaki.battleship;


import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void testNewGame() {
        Board board = new Board(7, 6);
        board = board.addShip(new Ship(5, Direction.right), 1, 2);
        board = board.addShip(new Ship(2, Direction.down), 5, 4);
        Approvals.verify(board);
    }

}