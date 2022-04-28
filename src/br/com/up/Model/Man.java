package br.com.up.Model;

public class Man {
    public boolean king;
    private Player player;

    public Man(Player player) {
        this.king = false;
        this.player = player;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);

        if(this.player.number == 1) {
        	stringBuilder.append("X");
        }else if(this.player.number == 2) {
        	stringBuilder.append("O");
        }

        return stringBuilder.toString();
    }

}
