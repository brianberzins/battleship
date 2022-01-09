package org.murasaki.battleship;

class Board {
    Fleet fleet;
    Coordinate[][] coordinates;

    Board() {
        this.coordinates = new Coordinate[8][8];
    }
}
