package org.murasaki.battleship;

import java.util.ArrayList;
import java.util.Collection;

class Fleet {
    private final Collection<Ship> ships;

    Fleet() {
        this.ships = new ArrayList<>();
        this.ships.add(Ship.AIRCRAFT_CARRIER);
        this.ships.add(Ship.BATTLESHIP);
        this.ships.add(Ship.CRUISER);
        this.ships.add(Ship.SUBMARINE);
        this.ships.add(Ship.DESTROYER);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Fleet otherFleet = (Fleet) other;
        if (ships.size() != otherFleet.ships.size()) return false;
        return ships.containsAll(otherFleet.ships);
    }

    public int size() {
        return ships.size();
    }

    public boolean contains(Ship ship) {
        return ships.contains(ship);
    }
}
