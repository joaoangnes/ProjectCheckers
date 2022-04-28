package br.com.up.Model;

public class Board {
    public Coordinate[][] table;

    public Board(int size) {
        this.table = new Coordinate[size][size];
    }
}
