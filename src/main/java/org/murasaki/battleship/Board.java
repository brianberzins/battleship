package org.murasaki.battleship;

import java.util.Arrays;
import java.util.stream.Collectors;

class Board {
    final Cell[][] grid;

    public Board(int length, int height) {
        grid = new Cell[length][height];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = Cell.empty;
            }
        }
    }

    private String row(int i){

        return Arrays.stream(grid[i]).map(Cell::toString).collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return Arrays.stream(grid).map(
                r -> Arrays.stream(r).map(Cell::toString).collect(Collectors.joining())
        ).collect(Collectors.joining("\n"));
    }
}
