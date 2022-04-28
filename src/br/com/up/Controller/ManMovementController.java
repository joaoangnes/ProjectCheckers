package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Coordinate;
import br.com.up.Model.Piece;
import br.com.up.Model.Player;

import java.util.ArrayList;

public class ManMovementController extends MovementController {

    public ManMovementController(Board board, Player player) {
        super(board, player);
    }

    // Selecionar todos os possíveis lugares onde a pode ir
    public ArrayList<Coordinate> possibleCoordinateToGo(Coordinate fromCoordinate) {
        ArrayList<Coordinate> possibleCoordinate = new ArrayList<Coordinate>();

        Coordinate leftCoordinate = validateLeftPosition(fromCoordinate);
        Coordinate rightCoordinate = validateRightPosition(fromCoordinate);

        if (leftCoordinate != null) {
            possibleCoordinate.add(leftCoordinate);
        }
        if (rightCoordinate != null) {
            possibleCoordinate.add(rightCoordinate);
        }

        return possibleCoordinate;
    }

    private Coordinate validateLeftPosition(Coordinate fromCoordinate) {
        Coordinate toCoordinate;

        if (this.player.getNumber() == 1) {
            int coordinateX = fromCoordinate.getX() - 1;
            int coordinateY = fromCoordinate.getY() - 1;
            if (!IsValidCoordinate(coordinateX, coordinateY)) {
                return null;
            }
            toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            
            // tem inimigo
            /*if(IsAlliedPiece(coordinateX, coordinateY)) {
            	// se no lugar 2 esta livre
            	coordinateX = fromCoordinate.getX() - 2;
                coordinateY = fromCoordinate.getY() - 2;
                if(!IsPlaceFree(coordinateX, coordinateY)) {
                	return null;
                }
                toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            }*/
        } else {
            int coordinateX = fromCoordinate.getX() + 1;
            int coordinateY = fromCoordinate.getY() - 1;
            if (!IsValidCoordinate(coordinateX, coordinateY)) {
                return null;
            }
            toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            
            // tem inimigo
            /*if(IsAlliedPiece(coordinateX, coordinateY)) {
            	// se no lugar 2 esta livre
            	coordinateX = fromCoordinate.getX() + 2;
                coordinateY = fromCoordinate.getY() - 2;
                if(!IsPlaceFree(coordinateX, coordinateY)) {
                	return null;
                }
                toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            }*/
        }

        // tem um espaço vazio
        if (toCoordinate.getPiece() == null) {
            return toCoordinate;
        }

        
        
        return validateLeftPosition(toCoordinate);
    }
    private Coordinate validateRightPosition(Coordinate fromCoordinate) {
        Coordinate toCoordinate;

        if (this.player.getNumber() == 1) {
            int coordinateX = fromCoordinate.getX() - 1;
            int coordinateY = fromCoordinate.getY() + 1;
            if (!IsValidCoordinate(coordinateX, coordinateY)) {
                return null;
            }
            toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            
            // tem inimigo
            /*if(IsAlliedPiece(coordinateX, coordinateY)) {
            	// se no lugar 2 esta livre
            	coordinateX = fromCoordinate.getX() - 2;
                coordinateY = fromCoordinate.getY() + 2;
                if(!IsPlaceFree(coordinateX, coordinateY)) {
                	return null;
                }
                toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            }*/
        } else {
            int coordinateX = fromCoordinate.getX() + 1;
            int coordinateY = fromCoordinate.getY() + 1;
            if (!IsValidCoordinate(coordinateX, coordinateY)) {
                return null;
            }
            toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            
            // tem inimigo
            /*if(IsAlliedPiece(coordinateX, coordinateY)) {
            	// se no lugar 2 esta livre
            	coordinateX = fromCoordinate.getX() + 2;
                coordinateY = fromCoordinate.getY() + 2;
                if(!IsPlaceFree(coordinateX, coordinateY)) {
                	return null;
                }
                toCoordinate = this.board.getTable()[coordinateX][coordinateY];
            }*/
        }

        // tem um espaço vazio
        if (toCoordinate.getPiece() == null) {
            return toCoordinate;
        }

        // tem inimigo
        //   se no lugar 2 esta livre
        return validateRightPosition(toCoordinate);
    }

    private boolean IsValidCoordinate(int coordinateX, int coordinateY) {
        if (IsOutsideOfBoard(coordinateX, coordinateY)) {
            return false;
        }

        return !IsAlliedPiece(coordinateX, coordinateY);
    }

    private boolean IsAlliedPiece(int coordinateX, int coordinateY) {
        Coordinate toCoordinate =  this.board.getTable()[coordinateX][coordinateY];
        if (toCoordinate.getPiece() == null) {
            return false;
        }
        //return toCoordinate.getPiece().getPlayer() == this.player;
        return true;
    }
    
    private boolean IsOutsideOfBoard(int coordinateX, int coordinateY) {
        if (coordinateX < 0 || coordinateX >= 8) {
            return true;
        }
        
        if (coordinateY < 0 || coordinateY >= 8) {
        	return true;
        }

        return false;
    }
}
