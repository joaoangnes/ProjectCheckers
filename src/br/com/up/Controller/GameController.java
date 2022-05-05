package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Player;
import br.com.up.View.BoardView;
import br.com.up.View.MenuView;

public class GameController {
	private Board board; // Tabuleiro
    private Player player1;
    private Player player2;
    private int turn; // Var aux, para mostar de quem é a vez de jogar || 1 = Jogador 1 && 2 = Jogador 2
	
    public void newGame() {
        this.player1 = new Player(1, "x");
        this.player2 = new Player(2, "o");
        BoardController boardController = new BoardController();
        this.board = boardController.CreateBoard(8, player1, player2);

        this.turn = 0;
    }
    
    public void runGame() {
    	BoardView boardView = new BoardView(this.board);
        BoardController boardController = new BoardController(this.board);
        MenuView menuView = new MenuView(this.player1, this.player2);

        do {
            menuView.showScores();
            boardView.printBoard();
            boardView.askPlayInformation(DefinePlayerTurn());


            this.turn++;
        } while(!boardController.isGameFinished());
    }

    private Player DefinePlayerTurn() {
        if (this.turn % 2 == 0) {
            return this.player1;
        }

        return this.player2;
    }
}
