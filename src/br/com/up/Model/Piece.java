package br.com.up.Model;

public abstract class Piece {
    public Player player;
    public boolean isKing;

    public Piece(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return this.player.symbol;
    }
}
