package br.com.up.Model;

public class Player {
    private int number;
    private String symbol;
	public int points;

    public Player(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
		this.points = 0;
    }

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
    
    
}
