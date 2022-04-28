package br.com.up.Controller;

import br.com.up.Model.*;

import java.util.ArrayList;

public class BoardController {
    private int size;
    public Board board;
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
		Coordinate Coordinate = this.board.table[coordinateX][coordinateY];

    	// Faz a validação se a peça escolhida pertence ao seu conjunto de peças ou se é um campo vazio
		if(Coordinate.piece == null) {
			return false;
    	}

		MovementController movementController;
		if (Coordinate.piece.isKing) {
			movementController = new KingMovementController(this.board, player);
		} else {
			movementController = new ManMovementController(this.board, player);
		}

		return movementController.possibleCoordinateToGo(Coordinate).size() != 0;
    }

	public boolean IsValidPlay(int fromCoordinateX, int fromCoordinateY, int toCoordinateX, int toCoordinateY, Player player) {
		Coordinate fromCoordinate = this.board.table[fromCoordinateX][fromCoordinateY];

		MovementController movementController;
		if (fromCoordinate.piece.isKing) {
			movementController = new KingMovementController(this.board, player);
		} else {
			movementController = new ManMovementController(this.board, player);
		}
		ArrayList<Coordinate> possibleCoordinates = movementController.possibleCoordinateToGo(fromCoordinate);

		for (Coordinate possibleToCoordinate : possibleCoordinates) {
			if (possibleToCoordinate.x == toCoordinateX && possibleToCoordinate.y == toCoordinateY) {
				return true;
			}
		}

		return false;
	}

    // Parametros: Coordenada da peça e coordenada do local da jogada 
	public void movePiece(int fromCoordinateX, int fromCoordinateY, int toCoordinateX, int toCoordinateY) {
    	// Armazena a peça escolhida pelo jogador
    	Coordinate from = this.board.table[fromCoordinateX - 1][fromCoordinateY - 1];
		Coordinate to = this.board.table[toCoordinateX - 1][toCoordinateY - 1];

		to.piece = from.piece; // Muda a peça para o local escolhido
		from.piece = null; // Deixa vazio a casa da peça escolhida
    }

    private void fillBoard() {
		putCoordinate();

        putPlayer1Man();
        putPlayer2Man();
    }

	private void putCoordinate() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.board.table[i][j] = new Coordinate(i, j);
			}
		}
	}

    private void putPlayer2Man() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < this.size; j++) {
                boolean pairLine = (i % 2 == 0);
                boolean pairColumn = (j % 2 == 0);

                if ((pairLine && !pairColumn) || (!pairLine && pairColumn)) {
                    Coordinate coordinate = this.board.table[i][j];
					coordinate.piece = new Man(this.player2);
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
					Coordinate coordinate = this.board.table[i][j];
					coordinate.piece = new Man(this.player1);
                }
            }
        }
    }

	public boolean isGameFinished() {
		return false;
	}
}
