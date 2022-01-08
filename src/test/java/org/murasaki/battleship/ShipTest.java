package org.murasaki.battleship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void shipSizes() {
        assertEquals(5, Ship.AIRCRAFT_CARRIER.size);
        assertEquals(4, Ship.BATTLESHIP.size);
        assertEquals(3, Ship.CRUISER.size);
        assertEquals(3, Ship.SUBMARINE.size);
        assertEquals(2, Ship.DESTROYER.size);
    }

}