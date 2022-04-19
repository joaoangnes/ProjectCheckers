package br.com.up.Model;

public class Board {
    public Man[][] manTable;

    public Board(int size) {
        this.manTable = new Man[size][size];
    }
}
