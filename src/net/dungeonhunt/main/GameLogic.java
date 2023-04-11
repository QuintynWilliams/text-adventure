package net.dungeonhunt.main;

import java.util.Scanner;
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    public static String[] enemies = {"Goblin", "Goblin", "Ghoul", "Ghoul", "Troll Ghoul"};

    public static int place = 0, act = 1;
    public static String[] places = {"Southern Plains", "Marquess Dungeons", "Grand Temple", "Town Square"};

    public static int readInt(String prompt, int userChoices) {
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    public static void clearConsole () {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void printSeparator (int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeading (String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingToContinue () {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Welcome to Ghoul Hunter");
        System.out.println("A text RPG for CodeUp");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("What's your name?");
            name = scanner.next();
            clearConsole();
            printHeading("Your name is " + name + "\n Is that correct?");
            System.out.println("[1] Yes!");
            System.out.println("[2] No, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }
        } while (!nameSet);

        Story.printIntro();

        player = new Player(name);

        Story.printActOneIntro();

        isRunning = true;

        gameLoop();
    }

    public static void checkAct() {
        if (player.xp >= 10 && act == 1) {
            act = 2;
            place = 1;
            Story.printActOneOutro();
            player.chooseTrait();
            Story.printActTwoIntro();
            enemies[0] = "Legion Scum";
            enemies[1] = "Legion Scum";
            enemies[2] = "Legion Soldier";
            enemies[3] = "Legion Soldier II";
            enemies[4] = "Legion Captain";
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            Story.printActTwoOutro();
            player.chooseTrait();
            Story.printActThreeIntro();
            enemies[0] = "Legion Scum-Lord";
            enemies[1] = "Legion Scum-Lord";
            enemies[2] = "Legion Soldier II";
            enemies[3] = "Legion Soldier IV";
            enemies[4] = "Legion Tanker";
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Shop";
            player.hp = player.maxHP;
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            Story.printActThreeOutro();
            player.chooseTrait();
            Story.printActFourIntro();
            player.hp = player.maxHP;
//            finalBattle();
        }
    }

    public static void randomEncounter() {
        int encounter = (int) (Math.random() * encounters.length);
        if (encounters[encounter].equals("Battle")) {
//            randomBattle();
        } else if (encounters[encounter].equals("Rest")) {
//            takeRest();
        } else {
//            Shop();
        }
    }

    public static void continueJourney() {
        checkAct();
        if (act != 4) {
            randomEncounter();
        }
    }

    public static void characterInfo() {
        clearConsole();
        printHeading("Character Info");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHP);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);

        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeparator(20);
        }

        anythingToContinue();
    }

    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeparator(20);
        System.out.println("[1] Continue on your journey");
        System.out.println("[2] Character Info");
        System.out.println("[3] Exit Game");
    }

    public static void gameLoop() {
        while(isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                continueJourney();
            } else if(input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }
}
