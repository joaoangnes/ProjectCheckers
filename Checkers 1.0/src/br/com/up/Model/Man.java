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

        if (this.king) {
            stringBuilder.append("K");
        } else {
            stringBuilder.append("M");
        }
        stringBuilder.append(this.player.number);

        return stringBuilder.toString();
    }

}
