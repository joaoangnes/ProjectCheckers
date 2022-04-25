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
    	int playerTime = 1; // Var aux, para mostar de quem � a vez de jogar || 1 = Jogador 1 && 2 = Jogador 2
    	
    	BoardController boardController = new BoardController();
    	BoardView boardView = new BoardView(this.board);
    	
    	// Loop infinito para funcionar a trocar de jogadores 
    	// Substituir o 'true' pela fun��o que verifica o fim do jogo 
    	// Falta: 
    	//	-Verifica��es de jogadas para as damas 
    	// 	-Verifica��es se a pe�a jogada se tornou uma dama
    	// 	-Verifica��o se a pe�a escolhida � dama ou normal
    	while(true) {
    		
    		boardView.askPlayInformation(playerTime);
            boardView.printBoard();
            
            // Caso for o Jogador 2
            if(playerTime == 2) {
    			playerTime = 1; // Muda para a vez do Jogador 1
    		}else { // Caso for o Jogador 1
    			playerTime += 1; // Muda para a vez do Jogador 2
    		}
           
    	}
    	
    }
    
}
