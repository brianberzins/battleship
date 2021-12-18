package org.murasaki.battleship;

import java.util.Arrays;
import java.util.Collections;

class Board {
    final Cell[] grid;
    final int length;
    final int height;

    Board(int length, int height) {
        this(Collections.nCopies(length * height, Cell.empty).toArray(new Cell[0]), length, height);
    }

    Board(Cell[] grid, int length, int height) {
        this.grid = grid;
        this.length = length;
        this.height = height;
    }

    
    Board addShip(Ship ship, int x, int y) {
        Cell[] newGrid = Arrays.copyOf(grid, grid.length);
        switch (ship.direction()) {
            case right -> {
                for (int s = 0; s < ship.size(); s++) {
                    assignAsShip(newGrid, (y * length) + x + s);
                }
            } 
            case down -> {
                for (int s = 0; s < ship.size(); s++) {
                    assignAsShip(newGrid, (y * length) + x + (s * length));
                }
            }
        }
        return new Board(newGrid, length, height);
    }

    private void assignAsShip(Cell[] newGrid, int i) {
        if (newGrid[i] == Cell.ship) {
            throw new IllegalArgumentException();
        }
        newGrid[i] = Cell.ship;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            if (i % length == 0 && i != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(grid[i].toString());
        }
        return stringBuilder.toString();
    }

    int getIndex(int x, int y) {
        if (x < 0 || length < x || y < 0 || height < y) {
            throw new IndexOutOfBoundsException();
        }
        return (y * length) + x;
    }

    Board fireShot(int x, int y) {
        int i = getIndex(x, y);
        Cell[] newGrid = Arrays.copyOf(grid, grid.length);
        newGrid[i] = grid[i] == Cell.ship ? Cell.hit : Cell.miss;
        return new Board(newGrid, length, height);
    }
}
