package org.murasaki.battleship;

class TestPlayer implements Player {

    @Override
    public Board placeShips(Board board, Fleet fleet) {
        board.fleet = fleet;
        return board;
    }
}
