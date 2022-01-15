package org.murasaki.battleship;

class ShotResult {

    ShotResultType type;
    Ship ship;

    ShotResult(ShotResultType type, Ship ship) {
        this.type = type;
        this.ship = ship;
    }
}
