package br.com.up.View;

import java.util.Scanner;

import br.com.up.Controller.BoardController;
import br.com.up.Model.Board;
import br.com.up.Model.Man;

public class BoardView {
    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void printBoard() {
    	System.out.println("");
        for (Man[] line : this.board.manTable) {
            for (Man man : line) {
                if (man != null) {
                    System.out.print(" | " + man.toString());
                } else {
                    System.out.print(" |   ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void askPlayInformation(int numPlayer) {
    	Scanner scanner = new Scanner(System.in);
    	BoardController boardController = new BoardController(this.board);
    	
    	int linMan = 0, colMan = 0; // Coordenada da pe�a a ser utilizada
    	int linPlay = 0, colPlay  = 0; // Coordenada da jogada a ser efetuada
    	int chosenValidator = 0, playValidator = 0; // Aux Validadores
    	
    	System.out.println("===================");
    	System.out.println("Jogador "+ numPlayer + ":" ); // Jogador que est� na vez de efetuar a jogada
    
    	// At� o jogador escolher uma pe�a valida, ele ir� pedir para informar novamente
    	while(chosenValidator!=1) {
	    	System.out.print("Informe a linha da pe�a a ser utilizada: ");
	    	linMan = scanner.nextInt();
	    	System.out.print ("Insira a coluna da pe�a a ser utilizada: ");  
	    	colMan = scanner.nextInt();
	    	
	    	// Verifica��o se � possivel escolher a pe�a escolhida pelo jogador
	    	chosenValidator = boardController.chosenManValidator(linMan, colMan, numPlayer);
    	}
    	
    	// At� o jogador escolher uma jogada valida, ele ir� pedir para informar novamente;
    	while(playValidator!=1) {
    		System.out.print("Informe a linha do local da jogada a ser realizada: ");
        	linPlay = scanner.nextInt();
        	System.out.print ("Informe a coluna do local da jogada a ser realizada: ");  
        	colPlay = scanner.nextInt();
        	
        	if(numPlayer == 1) {
        		playValidator = boardController.validatePlayPlayer1(linMan, colMan, linPlay, colPlay);
        	} else {
        		playValidator = boardController.validatePlayPlayer2(linMan, colMan, linPlay, colPlay);
        	}
        	
    	}
    	
    	System.out.println("===================");
    	// Caso passe de todas as valida��es chama a fun��o para efetuar a jogada
    	boardController.moveMan(linMan, colMan, linPlay, colPlay); // Efetua a jogada
    	System.out.println("Jogada Efetuada com sucesso!!");
    	System.out.println("===================");
    }
}
