package org.murasaki.battleship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.murasaki.battleship.ShotResultType.*;

class Board {
    static final int SIZE = 10;
    Fleet fleet;
    Coordinate[][] coordinates;
    List<Coordinate> firedUponCoordinates;
    Map<Ship, List<Coordinate>> shipMap;

    Board() {
        this.coordinates = new Coordinate[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                coordinates[i][j] = new Coordinate(i,j);
            }
        }
        this.fleet = new Fleet();
        this.firedUponCoordinates = new ArrayList<>();
        this.shipMap = new HashMap<>();
    }

    boolean placeShip(Ship ship, Coordinate coordinate, Orientation orientation) {
        assert fleet.add(ship);
        List<Coordinate> coordinatesForShip = coordinatesForShip(ship, coordinate, orientation);
        for(Coordinate shipCoordinate : coordinatesForShip) {
            coordinates[shipCoordinate.x][shipCoordinate.y].ship = ship;
        }
        shipMap.put(ship, coordinatesForShip);
        return true;
    }

    List<Coordinate> coordinatesForShip(Ship ship, Coordinate origin, Orientation orientation) {
        int horizontal_increment = orientation == Orientation.HORIZONTAL ? 1 : 0;
        int vertical_increment = orientation == Orientation.VERTICAL ? 1 : 0;
        List<Coordinate> shipCoordinates = new ArrayList<>();
        for(int i = 0; i < ship.size; i++) {
            int x = origin.x + (i * horizontal_increment);
            int y = origin.y + (i * vertical_increment);
            // TODO validate coordinates and check for overlaps.
            shipCoordinates.add(new Coordinate(x, y));
        }
        return shipCoordinates;
    }

    public Ship getShipAt(Coordinate coordinate) {
        return coordinates[coordinate.x][coordinate.y].ship;
    }

    ShotResult fireOn(Coordinate coordinate) {
        firedUponCoordinates.add(coordinate);
        Ship ship = coordinates[coordinate.x][coordinate.y].ship;
        if (ship == null) {
            return new ShotResult(MISSED, null);
        }
        if (firedUponCoordinates.containsAll(shipMap.get(ship))) {
            return new ShotResult(SANK, ship);
        }
        return new ShotResult(HIT, ship);
    }
}
