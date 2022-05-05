package br.com.up;

import br.com.up.Controller.GameController;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.newGame();
        gameController.runGame();
    }
}
