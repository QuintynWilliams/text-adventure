package net.dungeonhunt.main;

public class Enemy extends Characters {

    int playerXp;

    public Enemy (String name, int playerXp) {
        super(name, (int) (Math.random() * playerXp/3 + 5), (int) (Math.random() * (playerXp/4 + 2) + 1));
        this.playerXp = playerXp;
    }

    public int attack() {
        return 0;
    };
    public int defend() {
        return 0;
    };

}
