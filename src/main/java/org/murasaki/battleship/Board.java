package org.murasaki.battleship;

class Board {
    static final int SIZE = 10;
    Fleet fleet;
    Coordinate[][] coordinates;

    Board() {
        this.coordinates = new Coordinate[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                coordinates[i][j] = new Coordinate(i,j);
            }
        }
        this.fleet = new Fleet();
    }

    boolean placeShip(Ship ship, Coordinate coordinate, Orientation orientation) {
        assert fleet.add(ship);
        int horizontal_increment = orientation == Orientation.HORIZONTAL ? 1 : 0;
        int vertical_increment = orientation == Orientation.VERTICAL ? 1 : 0;

        for(int i = 0; i < ship.size; i++) {
            int x = coordinate.x + (i * horizontal_increment);
            int y = coordinate.y + (i * vertical_increment);
            // TODO validate coordinates and check for overlaps.
            coordinates[x][y].ship = ship;
        }
        return true;
    }

    public Ship getShipAt(Coordinate coordinate) {
        return coordinates[coordinate.x][coordinate.y].ship;
    }
}
