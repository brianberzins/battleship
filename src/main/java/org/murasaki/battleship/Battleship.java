package org.murasaki.battleship;

class Battleship {

    final Board player1Board;
    final Board player2Board;
    final Player next;

    Battleship(Board player1Board, Board player2Board) {
        this.player1Board = player1Board;
        this.player2Board = player2Board;
        this.next = Player.player1;
    }

    @Override
    public String toString() {
        return "next=" + next + "\nplayer1board=\n" + player1Board + "\nplayer2board=\n" + player2Board;
    }
}
