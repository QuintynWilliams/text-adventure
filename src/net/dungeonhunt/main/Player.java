package net.dungeonhunt.main;

public class Player extends Characters {

    public int numAtkUpgrades, numDefUpgrades;

    public String [] atkUpgrades = {"Strength", "Training", "Insight", "Hand of God"};
    public String [] defUpgrades = {"Reflex", "Thick Skin", "Chain Mail", "Divine Blessing"};

    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        chooseTrait();
    }

    public int attack() {
        return 0;
    };
    public int defend() {
        return 0;
    };

    public void chooseTrait() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        if (input == 1) {
            GameLogic.printHeading("You choose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }

}
