package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Coordinate;
import br.com.up.Model.Player;

public abstract class MovementController {
    private Board board;
    private Player player;

    public MovementController(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public abstract Coordinate[] possiblePlaceToGo(int linMan, int colMan);
}
