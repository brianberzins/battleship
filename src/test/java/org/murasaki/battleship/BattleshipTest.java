package org.murasaki.battleship;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class BattleshipTest {

    @Test
    void testConstructor() {
        BattleshipGame game = new BattleshipGame();
        Approvals.verify(game);
    }

}
