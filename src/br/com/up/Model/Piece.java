package br.com.up.Model;

public abstract class Piece {
    private Player player;
    private boolean isKing;

    public Piece(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return this.player.getSymbol();
    }

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isKing() {
		return isKing;
	}

	public void setKing(boolean isKing) {
		this.isKing = isKing;
	}
    
    
}
