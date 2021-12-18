package org.murasaki.battleship;

class Battleship {

    final Board player1Board;
    final Board player2Board;
    final Player next;

    Battleship(Board player1Board, Board player2Board) {
        this(player1Board, player2Board, Player.player1);
    }

    Battleship(Board player1Board, Board player2Board, Player next) {
        this.player1Board = player1Board;
        this.player2Board = player2Board;
        this.next = next;
    }

    public Battleship fireShot(int x, int y) {
        switch (next) {
            case player1 -> {
                return new Battleship(player1Board, player2Board.fireShot(x, y), Player.player2);
            }
            case player2 -> {
                return new Battleship(player1Board.fireShot(x, y), player2Board, Player.player1);
            }
            default ->
                    throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return "next=" + next + "\nplayer1board=\n" + player1Board + "\nplayer2board=\n" + player2Board;
    }

}
