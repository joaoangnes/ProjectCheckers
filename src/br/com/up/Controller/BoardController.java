package br.com.up.Controller;

import br.com.up.Model.Board;
import br.com.up.Model.Coordinate;
import br.com.up.Model.Man;
import br.com.up.Model.Player;

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
    
    // Valida se � possivel escolher a pe�a informada
    public boolean ValidatePlay(int linMan, int colMan, Player player) {
    	// Armazena a pe�a escolhida pelo jogador
    	Man man = this.board.manTable[linMan][colMan];

    	// Faz a valida��o se a pe�a escolhida pertence ao seu conjunto de pe�as ou se � um campo vazio
		if(man == null) {
			return false;
    	}

		MovementController movementController;
		if (man.king) {
			movementController = new KingMovementController(this.board, player);
		} else {
			movementController = new ManMovementController(this.board, player);
		}

		return movementController.possiblePlaceToGo(linMan, colMan).length != 0;
    }
    
    // Faz a verifica��o se tem jogadas permitidas para a pe�a escolhida do Jogador 1
    public boolean validatePossiblePlayPlayer1(int linMan, int colMan, String manStr) {

		// movimentos:
		// man
		// king


    	// Caso esteja nos limites do tabuleiro
    	if(colMan == 1) {
    		// Verifica se as jogadas possiveis dessa pe�a
    		if(String.valueOf(this.board.manTable[linMan+1][colMan+1]).equals(manStr)) {
				return false; // Caso s� tenha pe�as do seu time para voc� atacar, retorna como jogada invalida
			}else {
				return true; // Caso tenha ao menos um campo permitido para avan�ar retorna true
			}
    	} else if(colMan == 8){ // Caso esteja nos limites do tabuleiro
    		// Verifica se as jogadas possiveis dessa pe�a
    		if( String.valueOf(this.board.manTable[linMan+2][colMan-2]).equals(manStr)) {
				return false; // Caso s� tenha pe�as do seu time para voc� atacar, retorna como jogada invalida
			}else {
				return true; // Caso tenha ao menos um campo permitido para avan�ar retorna tru
			}
    	} else {
    		// Verifica se as jogadas possiveis dessa pe�a
    		if( String.valueOf(this.board.manTable[linMan+2][colMan]).equals(manStr)
			 && String.valueOf(this.board.manTable[linMan+2][colMan+2]).equals(manStr)) {
				return false; // Caso s� tenha pe�as do seu time para voc� atacar, retorna como jogada invalida
			}else {
				return true; // Caso tenha ao menos um campo permitido para avan�ar retorna true
			}
    	}
    }

	// Faz a verifica��o se tem jogadas permitidas para a pe�a escolhida do Jogador 2
    public boolean validatePossiblePlayPlayer2(int linMan, int colMan, String manStr) {
    	
    	// Caso esteja nos limites do tabuleiro
    	if(colMan == 1) {
    		// Verifica se as jogadas possiveis dessa pe�a 
    		if(String.valueOf(this.board.manTable[linMan-2][colMan+2]).equals(manStr)) {
				return false; // Caso s� tenha pe�as do seu time para voc� atacar, retorna como jogada invalida
			}else { 
				return true; // Caso tenha ao menos um campo permitido para avan�ar retorna true
			}
    	} else if(colMan == 8){ // Caso esteja nos limites do tabuleiro
    		// Verifica se as jogadas possiveis dessa pe�a 
    		if( String.valueOf(this.board.manTable[linMan-2][colMan-2]).equals(manStr)) {
				return false; // Caso s� tenha pe�as do seu time para voc� atacar, retorna como jogada invalida
			}else {
				return true; // Caso tenha ao menos um campo permitido para avan�ar retorna true
			}
    	} else {
    		// Verifica se as jogadas possiveis dessa pe�a 
    		if( String.valueOf(this.board.manTable[linMan-2][colMan]).equals(manStr) 
			 && String.valueOf(this.board.manTable[linMan-2][colMan-2]).equals(manStr)) {
				return false; // Caso s� tenha pe�as do seu time para voc� atacar, retorna como jogada invalida
			}else {
				return true; // Caso tenha ao menos um campo permitido para avan�ar retorna true
			}
    	}
    	
    }
    
    // Valida a jogada do Jogador 1
    public int validatePlayPlayer1(int linMan, int colMan, int linPlay, int colPlay) {
    	// Caso esteja nos limites do tabuleiro
    	if(colMan == 1) { // Caso ele esteja na extremidade esquerda ele tem apenas uma jogada permitida, caso n�o for dama
    		if(linMan+1 == linPlay && colMan+1 == colPlay) { // Valida se a jogada possivel � a escolhida
    			//verifica se posicao nao esta ocupada
    			if(this.board.manTable[linPlay - 1][colPlay - 1] == null) {
    				return 1; // Jogada Valida
    			}else {    				
    				System.out.println("");
            		System.out.println("==JOGADA INVALIDA==");
            		System.out.println("Informe novamente");
            		System.out.println("");
        			return 0; // Jogada invalida
    			}
    		}else {
    			System.out.println("");
        		System.out.println("==JOGADA INVALIDA==");
        		System.out.println("Informe novamente");
        		System.out.println("");
    			return 0; // Jogada invalida
    		}
    	} else if(colMan == 8){ // Caso ele esteja na extremidade direita ele tem apenas uma jogada permitida, caso n�o for dama
    		if(linMan+1 == linPlay && colMan-1 == colPlay) { // Valida se a jogada possivel � a escolhida
    			//verifica se posicao nao esta ocupada
    			if(this.board.manTable[linPlay - 1][colPlay - 1] == null) {
    				return 1; // Jogada Valida
    			}else {    				
    				System.out.println("");
            		System.out.println("==JOGADA INVALIDA==");
            		System.out.println("Informe novamente");
            		System.out.println("");
        			return 0; // Jogada invalida
    			}
    		}else {
    			System.out.println("");
        		System.out.println("==JOGADA INVALIDA==");
        		System.out.println("Informe novamente");
        		System.out.println("");
    			return 0; // Jogada invalida
    		}
    	} else { // Caso n�o for um caso de extremidade
    		// Verifica se o jogador est� efetuando uma das duas possiveis jogadas
    		if( (linMan+1 == linPlay && colMan+1 == colPlay) || (linMan+1 == linPlay && colMan-1 == colPlay) ) {
    			//verifica se posicao nao esta ocupada
    			if(this.board.manTable[linPlay - 1][colPlay - 1] == null) {
    				return 1; // Jogada Valida
    			}else {    				
    				System.out.println("");
            		System.out.println("==JOGADA INVALIDA==");
            		System.out.println("Informe novamente");
            		System.out.println("");
        			return 0; // Jogada invalida
    			}
    		}else {
    			System.out.println("");
        		System.out.println("==JOGADA INVALIDA==");
        		System.out.println("Informe novamente");
        		System.out.println("");
    			return 0; // Jogada Invalida
    		}
    	}
    }
    
    // Valida a jogada do Jogador 2
    public int validatePlayPlayer2(int linMan, int colMan, int linPlay, int colPlay) {
    	// Caso esteja nos limites do tabuleiro
    	if(colMan == 1) { // Caso ele esteja na extremidade esquerda ele tem apenas uma jogada permitida, caso n�o for dama
    		if(linMan-1 == linPlay && colMan+1 == colPlay) { // Valida se a jogada possivel � a escolhida
    			//verifica se posicao nao esta ocupada
    			if(this.board.manTable[linPlay - 1][colPlay - 1] == null) {
    				return 1; // Jogada Valida
    			}else {    				
    				System.out.println("");
            		System.out.println("==JOGADA INVALIDA==");
            		System.out.println("Informe novamente");
            		System.out.println("");
        			return 0; // Jogada invalida
    			}
    		}else {
    			System.out.println("");
        		System.out.println("==JOGADA INVALIDA==");
        		System.out.println("Informe novamente");
        		System.out.println("");
    			return 0; // Jogada invalida
    		}
    	} else if(colMan == 8){ // Caso ele esteja na extremidade direita ele tem apenas uma jogada permitida, caso n�o for dama
    		if(linMan-1 == linPlay && colMan-1 == colPlay) { // Valida se a jogada possivel � a escolhida
    			//verifica se posicao nao esta ocupada
    			if(this.board.manTable[linPlay - 1][colPlay - 1] == null) {
    				return 1; // Jogada Valida
    			}else {    				
    				System.out.println("");
            		System.out.println("==JOGADA INVALIDA==");
            		System.out.println("Informe novamente");
            		System.out.println("");
        			return 0; // Jogada invalida
    			}
    		}else {
    			System.out.println("");
        		System.out.println("==JOGADA INVALIDA==");
        		System.out.println("Informe novamente");
        		System.out.println("");
    			return 0; // Jogada invalida
    		}
    	} else { // Caso n�o for um caso de extremidade
    		// Verifica se o jogador est� efetuando uma das duas possiveis jogadas
    		if( (linMan-1 == linPlay && colMan+1 == colPlay) || (linMan-1 == linPlay && colMan-1 == colPlay) ) {
    			//verifica se posicao nao esta ocupada
    			if(this.board.manTable[linPlay - 1][colPlay - 1] == null) {
    				return 1; // Jogada Valida
    			}else {    				
    				System.out.println("");
            		System.out.println("==JOGADA INVALIDA==");
            		System.out.println("Informe novamente");
            		System.out.println("");
        			return 0; // Jogada invalida
    			}
    		}else {
    			System.out.println("");
        		System.out.println("==JOGADA INVALIDA==");
        		System.out.println("Informe novamente");
        		System.out.println("");
    			return 0; // JOgada Invalida
    		}
    	}
    }
    
    // Parametros: Coordenada da pe�a e coordenada do local da jogada 
	public void moveMan(int linMan, int colMan, int linPlay ,int colPlay) {
    	// Armazena a pe�a escolhida pelo jogador
    	Man man = this.board.manTable[linMan - 1][colMan - 1];
    	
    	this.board.manTable[linMan - 1][colMan - 1] = null; // Deixa vazio a casa da pe�a escolhida
    	this.board.manTable[linPlay - 1][colPlay - 1] = man; // Muda a pe�a para o local escolhido
    }

    private void fillBoard() {
        putPlayer1Man();
        putPlayer2Man();
    }

    private void putPlayer1Man() {
        for (int i = 0; i <= 2; i++) {
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
        for (int i = (this.size - 3); i < this.size; i++) {
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

	public boolean isGameFinished() {
		return false;
	}
}
