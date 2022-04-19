package br.com.up;

import br.com.up.Controller.BoardController;
import br.com.up.Controller.GameController;
import br.com.up.Model.Board;
import br.com.up.Model.Man;
import br.com.up.Model.Player;
import br.com.up.View.BoardView;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.newGame();
        
        // Roda o jogo
        // Necessita:
        // 	-Valida��es de qual o jogador est� jogando
        // 	-Valida��es de jogadas em geral.
        gameController.runGame();
        // comentario para testar o git
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

