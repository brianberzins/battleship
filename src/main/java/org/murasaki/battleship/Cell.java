package org.murasaki.battleship;

enum Cell {
    empty(" "),
    hit("X"),
    miss("0"),
    ship("*"),
    ;

    final String display;
    Cell(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }
}
