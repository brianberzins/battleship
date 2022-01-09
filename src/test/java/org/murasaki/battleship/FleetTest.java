package org.murasaki.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FleetTest {

    @Test
    void fleet() {
        Fleet fleet = new Fleet();
        assertEquals(5, fleet.size());
        assertTrue(fleet.contains(Ship.AIRCRAFT_CARRIER));
        assertTrue(fleet.contains(Ship.BATTLESHIP));
        assertTrue(fleet.contains(Ship.CRUISER));
        assertTrue(fleet.contains(Ship.SUBMARINE));
        assertTrue(fleet.contains(Ship.DESTROYER));
    }

}