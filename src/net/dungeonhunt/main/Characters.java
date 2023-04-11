package net.dungeonhunt.main;

public abstract class Characters {

    public String name;
    public int maxHP, hp, xp;

    public Characters(String name, int maxHP, int xp) {
        this.name = name;
        this.maxHP = maxHP;
        this.xp = xp;
        this.hp = maxHP;
    }

    public abstract int attack();
    public abstract int defend();

}
