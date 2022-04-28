package br.com.up.Model;

public class Player {
    private int number;
    private String symbol;

    public Player(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
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
