package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Player;
import br.com.up.View.BoardView;

public class GameController {
	private Board board; // Tabuleiro
	
    public void newGame() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        BoardController boardController = new BoardController();
        this.board = boardController.CreateBoard(8, player1, player2);
   
        BoardView boardView = new BoardView(this.board);
        boardView.printBoard();
    }
    
    public void runGame() {
    	BoardView boardView = new BoardView(this.board);
    	boardView.askPlayInformation();
        boardView.printBoard();
    }
    
}
