package org.murasaki.battleship;

import java.util.Collection;
import java.util.List;

class Battleship {

    static final Collection<Ship> FLEET = List.of(
            Ship.AIRCRAFT_CARRIER,
            Ship.BATTLESHIP,
            Ship.CRUISER,
            Ship.SUBMARINE,
            Ship.DESTROYER
    );
}
