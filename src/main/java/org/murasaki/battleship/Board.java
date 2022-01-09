package org.murasaki.battleship;

import java.util.Collection;

class Board {
    Fleet fleet;
    Coordinate[][] coordinates;

    Board() {
        this.coordinates = new Coordinate[8][8];
    }
}
