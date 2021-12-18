package org.murasaki.battleship;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class BattleshipTest {

    @Test
    void testBattleship() {
        Board player1Board = new Board(5, 5)
                .addShip(new Ship(3, Direction.right), 1, 2)
                .addShip(new Ship(2, Direction.down), 0, 3);
        Board player2Board = new Board(5, 5)
                .addShip(new Ship(3, Direction.down), 4, 2)
                .addShip(new Ship(2, Direction.down), 1, 2);
        Battleship battleship = new Battleship(player1Board, player2Board);

        LinkedList<Battleship> turns = new LinkedList<>();
        turns.add(battleship);
        turns.add(turns.getLast().fireShot(3, 3));
        turns.add(turns.getLast().fireShot(2, 1));
        turns.add(turns.getLast().fireShot(4, 3));
        turns.add(turns.getLast().fireShot(2, 2));

        Approvals.verifyAll("Turns", turns);
    }

}
