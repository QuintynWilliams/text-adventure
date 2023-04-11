package net.dungeonhunt.main;

import java.util.Random;
import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner startGame = new Scanner(System.in);
        System.out.println("Welcome to Ghoul Hunter");
        System.out.println("Are you ready to hunt? [Y/N]");
        String userStart = startGame.next();
        boolean confirmation = userStart.equalsIgnoreCase("Y");

        while (confirmation) {
            Scanner readName = new Scanner(System.in);
            System.out.println("What is your hero's name?");
            String userName = readName.next();
            System.out.printf("Welcome to the dungeon, %s...", userName);

            Scanner readRole = new Scanner(System.in);
            String availableRoles = """
             Key |  Class  |  HP  |  ATK  |  DEF  |  Potion  \s
            =====|=========|======|=======|=======|==========\s
              1  | Fighter |  15  |  15   |  15   |     6    \s
              2  | Mage    |  10  |  20   |  10   |     3    \s
              3  | Rogue   |  12  |  17   |  13   |     4    \s""";
            System.out.println("\nChose your class from below:");
            System.out.println(availableRoles);
            int userRole = readRole.nextInt();

            while (true) {
                if (userRole == 1 || userRole == 2 || userRole == 3) {
                    System.out.printf("Really? Okay %s. I'll show you to the entrance, the rest is up to you.", userName);
                    confirmation = false;
                    break;
                } else{
                    System.out.println("We can't prepare you for that role.\n Chose a valid role.");
                    readRole = new Scanner(System.in);
                    System.out.println(availableRoles);
                    userRole = readRole.nextInt();
                }
            }
        }

        int result = randomizer(3, 12);
//        System.out.println(result);
    }
    public static int randomizer(int min, int max) {
        Random random = new Random();
        boolean test = random.nextInt(30)==0;
        int bob = random.nextInt(max - min + 1) + min;
        if (test) {
            return bob * 3;
        } else {
            return bob;
        }
    }
}
