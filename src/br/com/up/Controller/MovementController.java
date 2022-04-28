package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Coordinate;
import br.com.up.Model.Player;

import java.util.ArrayList;

public abstract class MovementController {
    protected Board board;
    protected Player player;

    public MovementController(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public abstract ArrayList<Coordinate> possibleCoordinateToGo(Coordinate fromCoordinate);
}
