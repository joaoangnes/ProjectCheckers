package br.com.up.Model;

public abstract class Piece {
    private Player player;
    private boolean isKing;

    public Piece(Player player) {
        this.player = player;
    }

	public Player getPlayer() {
		return player;
	}

	public boolean isKing() {
		return isKing;
	}

	public void transformInKing() {
		this.isKing = true;
	}

	@Override
	public String toString() {
		if (this.isKing)
			return this.player.getSymbol().toUpperCase();

		return this.player.getSymbol();
	}
}
