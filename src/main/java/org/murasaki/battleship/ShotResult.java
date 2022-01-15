package org.murasaki.battleship;

import java.util.Objects;

class ShotResult {

    ShotResultType type;
    Ship ship;

    ShotResult(ShotResultType type, Ship ship) {
        this.type = type;
        this.ship = ship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShotResult that = (ShotResult) o;
        return type == that.type && ship == that.ship;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, ship);
    }

    @Override
    public String toString() {
        return "You " + type.name() + (type == ShotResultType.MISSED ? "" : " my " + ship.name());
    }
}
