package br.com.up.Model;

public class Board {
    private Coordinate[][] table;

    public Board(int size) {
        this.table = new Coordinate[size][size];
    }

	public Coordinate[][] getTable() {
		return table;
	}

	public void setTable(Coordinate[][] table) {
		this.table = table;
	}
    
    
}
