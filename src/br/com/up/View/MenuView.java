package br.com.up.View;

import br.com.up.Model.Player;

public class MenuView {
    private Player player1;
    private Player player2;

    public MenuView(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void showScores() {
        System.out.println("-----------------------------------");
        System.out.println("Pontuação");
        System.out.println("Jogador " + player1.getSymbol() + ": " + player1.points);
        System.out.println("Jogador " + player2.getSymbol() + ": " + player2.points);
        System.out.println("-----------------------------------");
    }
}
