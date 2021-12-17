package org.murasaki.battleship;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class BattleshipTest {

    @Test
    void testNewGame() {
        Board emptyBoard = new Board(5, 5);
        Battleship battleship = new Battleship(emptyBoard, emptyBoard);
        Approvals.verify(battleship);
    }

}
