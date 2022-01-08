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

}
