package br.com.up;

//import br.com.up.Controller.BoardController;
import br.com.up.Controller.GameController;
//import br.com.up.Model.Board;
//import br.com.up.Model.Man;
//import br.com.up.Model.Player;
//import br.com.up.View.BoardView;

public class Main {

    public static void main(String[] args) {
    	// Primeira vez que for rodar ele ir� criar o tabuleiro com as pe�as 
        GameController gameController = new GameController();
        gameController.newGame();
        gameController.runGame();
    }
}






















/*

para quem eu vou dar as responsabilidades?
temos algumasa divis'aoes de trabalho:
- guardar os dados
- gerenciar esses dados
- mostrar os dados


models:
Tabuleiro
    pecas[][]
Peca
Player

controllers:
TabuleiroController
    Tabuleiro
    PecaController

    MoverPeca
PecaController
    TranformarPecaEmDama




*
*
*
*
*
*
*/

