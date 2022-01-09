package org.murasaki.battleship;

class Board {
    Fleet fleet;
    Coordinate[][] coordinates;

    Board() {
        this.coordinates = new Coordinate[8][8];
        for(int i = 0; i < coordinates.length; i++) {
            for(int j = 0; j < coordinates[i].length; j++) {
                coordinates[i][j] = new Coordinate(i,j);
            }
        }
        this.fleet = new Fleet();
    }

    boolean placeShip(Ship ship, Coordinate coordinate, Orientation orientation) {
        assert fleet.add(ship);
        switch (orientation) {
            case HORIZONTAL -> {
                for(int i = coordinate.x; i < coordinate.x + ship.size; i++) {
                    // TODO: check if out of bounds
                    // TODO: check for overlap
                    coordinates[i][coordinate.y].ship = ship;
                }
            }
            case VERTICAL -> {
                for(int j = coordinate.y; j < coordinate.y + ship.size; j++) {
                    // TODO: check if out of bounds
                    // TODO: check for overlap
                    coordinates[coordinate.x][j].ship = ship;
                }
            }
        }


        coordinates[coordinate.x][coordinate.y].ship = ship;

        return true;
    }

    public Ship getShipAt(Coordinate coordinate) {
        return coordinates[coordinate.x][coordinate.y].ship;
    }
}
