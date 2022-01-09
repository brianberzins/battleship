package org.murasaki.battleship;

enum Ship {
    AIRCRAFT_CARRIER(5),
    BATTLESHIP(4),
    CRUISER(3),
    SUBMARINE(3),
    DESTROYER(2);

    final int size;

    Ship(int size) {
        this.size = size;
    }
}
