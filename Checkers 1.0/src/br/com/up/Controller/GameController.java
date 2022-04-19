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
    	int playerTime = 1; // Var aux, para mostar de quem é a vez de jogar || 1 = Jogador 1 && 2 = Jogador 2
    	
    	BoardController boardController = new BoardController();
    	BoardView boardView = new BoardView(this.board);
    	
    	// Loop infinito para funcionar a trocar de jogadores 
    	// Substituir o 'true' pela função que verifica o fim do jogo 
    	// Falta: 
    	//	-Verificações de jogadas para as damas 
    	// 	-Verificações se a peça jogada se tornou uma dama
    	// 	-Verificação se a peça escolhida é dama ou normal
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
