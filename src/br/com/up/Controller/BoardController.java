package br.com.up.Controller;

import br.com.up.Model.*;

import java.util.ArrayList;

public class BoardController {
    private int size;
    private Board board;
    private Player player1;
    private Player player2;

	public BoardController() {}

    public BoardController(Board board) {
    	this.board = board;
    }

    public Board CreateBoard(int size, Player player1, Player player2) {
        this.size = size;
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(size);

        this.fillBoard();
        
        return this.board;
    }
    
    // Valida se é possivel escolher a peça informada
    public boolean IsPiecePlayable(int coordinateX, int coordinateY, Player player) {
    	// Armazena a peça escolhida pelo jogador
		Coordinate Coordinate = this.board.getTable()[coordinateX][coordinateY];

    	// Faz a validação se a peça escolhida pertence ao seu conjunto de peças ou se é um campo vazio
		if(Coordinate.getPiece() == null) {
			return false;
    	}

		MovementController movementController;
		if (Coordinate.getPiece().isKing()) {
			movementController = new KingMovementController(this.board, player);
		} else {
			movementController = new ManMovementController(this.board, player);
		}

		return movementController.possibleCoordinateToGo(Coordinate).size() != 0;
    }

	public boolean IsValidPlay(int fromCoordinateX, int fromCoordinateY, int toCoordinateX, int toCoordinateY, Player player) {
		Coordinate fromCoordinate = this.board.getTable()[fromCoordinateX][fromCoordinateY];

		MovementController movementController;
		if (fromCoordinate.getPiece().isKing()) {
			movementController = new KingMovementController(this.board, player);
		} else {
			movementController = new ManMovementController(this.board, player);
		}
		
		ArrayList<Coordinate> possibleCoordinates = movementController.possibleCoordinateToGo(fromCoordinate);

		for (Coordinate possibleToCoordinate : possibleCoordinates) {
			if (possibleToCoordinate.getX() == toCoordinateX && possibleToCoordinate.getY() == toCoordinateY) {
				return true;
			}
		}

		return false;
	}

    // Parametros: Coordenada da peça e coordenada do local da jogada 
	public void movePiece(int fromCoordinateX, int fromCoordinateY, int toCoordinateX, int toCoordinateY) {
    	// Armazena a peça escolhida pelo jogador
    	Coordinate from = this.board.getTable()[fromCoordinateX - 1][fromCoordinateY - 1];
		Coordinate to = this.board.getTable()[toCoordinateX - 1][toCoordinateY - 1];

		boolean isKillerPlay = (Math.abs(from.getX() - to.getX()) == 2);
		if (isKillerPlay) {
			boolean toRight = (to.getY() - from.getY()) > 0;
			boolean toTop = (from.getX() - to.getX()) > 0;
			
			int killCoordinateX = 0; 
			int killCoordinateY = 0;
			if (toTop && toRight) {
				killCoordinateX = from.getX() - 1;
				killCoordinateY = from.getY() + 1;
			}
			
			if (toTop && !toRight) {
				killCoordinateX = from.getX() - 1;
				killCoordinateY = from.getY() - 1;	
			}
			
			if (!toTop && toRight) {
				killCoordinateX = from.getX() + 1;
				killCoordinateY = from.getY() + 1;	
			}
			
			if (!toTop && !toRight) {
				killCoordinateX = from.getX() + 1;
				killCoordinateY = from.getY() - 1;	
			}
			
			this.board.getTable()[killCoordinateX][killCoordinateY].setPiece(null);

			Piece piecePlayed = from.getPiece();
			piecePlayed.getPlayer().points += 1;
		}

		to.setPiece(from.getPiece()); // Muda a peça para o local escolhido
		from.setPiece(null); // Deixa vazio a casa da peça escolhida
		boolean transformToKing = validateTransformToKing(to);
		//transformToKing = true;
		if (transformToKing)
			to.getPiece().transformInKing();
    }

	public boolean validateTransformToKing(Coordinate coordinate) {
		Piece piece = coordinate.getPiece();
		if (piece.isKing()) {
			return false;
		}
		if (piece.getPlayer().getNumber() == 2 && coordinate.getX() == 7)
			return true;

		if (piece.getPlayer().getNumber() == 1 && coordinate.getX() == 0)
			return true;

		return false;
	}

    private void fillBoard() {
		putCoordinate();

        putPlayer1Man();
        putPlayer2Man();
    }

	private void putCoordinate() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.board.getTable()[i][j] = new Coordinate(i, j);
			}
		}
	}

    private void putPlayer2Man() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < this.size; j++) {
                boolean pairLine = (i % 2 == 0);
                boolean pairColumn = (j % 2 == 0);

                if ((pairLine && !pairColumn) || (!pairLine && pairColumn)) {
                    Coordinate coordinate = this.board.getTable()[i][j];
					coordinate.setPiece(new Man(this.player2));
                }
            }
        }
    }

    private void putPlayer1Man() {
        for (int i = (this.size - 3); i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                boolean pairLine = (i % 2 == 0);
                boolean pairColumn = (j % 2 == 0);

                if ((pairLine && !pairColumn) || (!pairLine && pairColumn)) {
					Coordinate coordinate = this.board.getTable()[i][j];
					coordinate.setPiece(new Man(this.player1));
                }
            }
        }
    }

	public boolean isGameFinished() {
		return false;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
}
