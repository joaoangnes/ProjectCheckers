package br.com.up.View;

import java.util.Scanner;

import br.com.up.Controller.BoardController;
import br.com.up.Model.*;

public class BoardView {
    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void printBoard() {
    	int i = 1, j = 1, verifica = 0;
    	System.out.println("    1   2   3   4   5   6   7   8");
    	System.out.println("   -------------------------------");
        for (Coordinate[] line : this.board.table) {
            for (Coordinate coordinate : line) {
            	if(verifica == 0) {
                if (coordinate.piece != null) {
                    System.out.print(i + " | " + coordinate.piece);
                } else {
                    System.out.print(i + " |  ");
                }
                verifica = 1;
            	}else {
            		if (coordinate.piece != null) {
                        System.out.print(" | " + coordinate.piece);
                    } else {
                        System.out.print(" |  ");
                    }
            	}
            	if(j == 8) {
                	System.out.print(" |");
                	j = 0;
                }
            	j++;
            }
            
            System.out.println("");
            i++;
            
            verifica = 0;
        }
        System.out.println("   -------------------------------");
    }
    
    public void askPlayInformation(Player player) {
    	Scanner scanner = new Scanner(System.in);
    	BoardController boardController = new BoardController(this.board);
    	
    	int fromCoordinateX = 0, fromCoordinateY = 0; // Coordenada da pe�a a ser utilizada
    	int toCoordinateX = 0, toCoordinateY  = 0; // Coordenada da jogada a ser efetuada
    	
    	System.out.println("");
    	System.out.println("==================================");
		System.out.println("Jogador (" + player.symbol + ")");

    	// At� o jogador escolher uma pe�a valida, ele ir� pedir para informar novamente
		boolean validPlay;
    	do {
	    	System.out.print("Informe a linha da pe�a a ser utilizada: ");
	    	fromCoordinateX = scanner.nextInt();
	    	System.out.print ("Informe a coluna da pe�a a ser utilizada: ");
	    	fromCoordinateY = scanner.nextInt();
	    	
	    	// Verifica��o se � possivel escolher a pe�a escolhida pelo jogador
	    	boolean PlayablePiece = boardController.IsPiecePlayable(fromCoordinateX - 1, fromCoordinateY - 1, player);

			if (!PlayablePiece) {
				System.out.println("");
				System.out.println("==PE�A INVALIDA==");
				System.out.println("Informe novamente");
				System.out.println("");
			}

			System.out.print("Informe a linha do local da jogada a ser realizada: ");
			toCoordinateX = scanner.nextInt();
			System.out.print ("Informe a coluna do local da jogada a ser realizada: ");
			toCoordinateY = scanner.nextInt();

			validPlay = boardController.IsValidPlay(fromCoordinateX, fromCoordinateY, toCoordinateX, toCoordinateY, player);
    	} while(!validPlay);

		System.out.println("===================");
    	// Caso passe de todas as valida��es chama a fun��o para efetuar a jogada
    	boardController.movePiece(fromCoordinateX, fromCoordinateY, toCoordinateX, toCoordinateY); // Efetua a jogada
    	System.out.println("Jogada Efetuada com sucesso!!");
    	System.out.println("===================");
    }
}
