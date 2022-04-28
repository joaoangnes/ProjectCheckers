package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Coordinate;
import br.com.up.Model.Player;

import java.util.ArrayList;

public class KingMovementController extends MovementController {

    public KingMovementController(Board board, Player player) {
        super(board, player);
    }

    public ArrayList<Coordinate> possibleCoordinateToGo(Coordinate coordinate) {
        ArrayList<Coordinate> possibleCoordinate = new ArrayList<Coordinate>();

        return possibleCoordinate;
    }
}
