package org.murasaki.battleship;

import java.util.ArrayList;
import java.util.Collection;

class Fleet {
    Collection<Ship> ships;

    Fleet() {
        this.ships = new ArrayList<>();
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

    public boolean add(Ship ship) {
        return ships.add(ship);
    }
}
