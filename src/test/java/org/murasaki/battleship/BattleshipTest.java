package org.murasaki.battleship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BattleshipTest {

    @Test
    void fleet() {
        assertEquals(5, Battleship.FLEET.size());
        assertTrue(Battleship.FLEET.contains(Ship.AIRCRAFT_CARRIER));
        assertTrue(Battleship.FLEET.contains(Ship.BATTLESHIP));
        assertTrue(Battleship.FLEET.contains(Ship.CRUISER));
        assertTrue(Battleship.FLEET.contains(Ship.SUBMARINE));
        assertTrue(Battleship.FLEET.contains(Ship.DESTROYER));
    }
}
