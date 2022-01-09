package org.murasaki.battleship;

class TestPlayer implements Player {

    @Override
    public Board placeShips(Fleet fleet) {
        Board board = new Board();
        board.fleet = fleet;
        return board;
    }
}
