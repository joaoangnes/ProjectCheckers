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
    }
    
    public void askPlayInformation() {
    	Scanner scanner = new Scanner(System.in);
    	int linMan, colMan;
    	int linPlay, colPlay;
    	
    	System.out.println("===================");
    	System.out.println("Informe a linha da peça a ser utilizada: ");
    	linMan = scanner.nextInt();
    	System.out.println ("Insira a coluna da peça a ser utilizada: ");  
    	colMan = scanner.nextInt();
    	System.out.println("Informe a linha do local da jogada a ser realizada: ");
    	linPlay = scanner.nextInt();
    	System.out.println ("Informe a coluna do local da jogada a ser realizada: ");  
    	colPlay = scanner.nextInt();
    	System.out.println("===================");
    	
    	BoardController boardController = new BoardController(this.board);
    	boardController.moveMan(linMan, colMan, linPlay, colPlay);
    }
}
