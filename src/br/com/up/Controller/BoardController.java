package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Man;
import br.com.up.Model.Player;

import java.util.stream.Stream;

public class BoardController {
    private int size;
    public Board board;
    private Player player1;
    private Player player2;
    

    public BoardController(Board board) {
    	this.board = board;
    }
    
    public BoardController() {
    	
    }

    public Board CreateBoard(int size, Player player1, Player player2) {
        this.size = size;
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(size);

        this.fillBoard();
        
        return this.board;
    }

    
    // Parametros: Coordenada da peça e coordenada do local da jogada 
	public void moveMan(int linMan, int colMan, int linPlay ,int colPlay) {
    	// Armazena a coordenada do local da peça escolhida pelo jogador
    	Man man = this.board.manTable[linMan][colMan];
    	
    	this.board.manTable[linMan][colMan] = null;
    	
    	this.board.manTable[linPlay][colPlay] = man;
    }

    private void fillBoard() {
        putPlayer1Man();
        putPlayer2Man();
    }

    private void putPlayer1Man() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < this.size; j++) {
                boolean pairLine = (i % 2 == 0);
                boolean pairColumn = (j % 2 == 0);

                if (pairLine && !pairColumn) {
                    this.board.manTable[i][j] = new Man(this.player1);
                }

                if (!pairLine && pairColumn) {
                    this.board.manTable[i][j] = new Man(this.player1);
                }
            }
        }
    }

    private void putPlayer2Man() {
        for (int i = (this.size - 2); i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                boolean pairLine = (i % 2 == 0);
                boolean pairColumn = (j % 2 == 0);

                if (pairLine && !pairColumn) {
                    this.board.manTable[i][j] = new Man(this.player2);
                }

                if (!pairLine && pairColumn) {
                    this.board.manTable[i][j] = new Man(this.player2);
                }
            }
        }
    }


}
