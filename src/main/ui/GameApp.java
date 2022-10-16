package ui;

import model.GameData;
import model.ItemList;

import java.util.Scanner;

public class GameApp {
    private Scanner input;
    private GameData player;
    private String playerName;
    private int choice;
    private ItemList items;

    public GameApp() {
        runGame();
    }

    public void runGame() {
        input = new Scanner(System.in);
        player = new GameData("a0a");
        items = new ItemList();

        System.out.println("Welcome to the game! Please enter your name.");
        playerName = input.next();
        System.out.println("Welcome, " + playerName + "! Let's get started!");
        firstSection();
    }

    @SuppressWarnings("methodlength") //currently 26 lines long
    public void firstSection() {

        input = new Scanner(System.in);
        choice = 0;

        System.out.println("You are inside a spaceship. The Captain wants you to get rid of our cargo.");
        System.out.println("The Captain said that the cargo is to the right. Which way do you go?");
        System.out.println("1. Right");
        System.out.println("2. Left");
        System.out.println("3. Save Progress");
        System.out.println("4. Show Items");
        System.out.println("5. Go Back to Opening Screen");
        System.out.println("6. End Game");
        choice = input.nextInt();

        if (choice == 1) {
            cheeseRoom();
        } else if (choice == 2) {
            left();
        } else if (choice == 3) {
            saveProgress();
        } else if (choice == 4) {
            items.getItems();
        } else if (choice == 5) {
            runGame();
        } else if (choice == 6) {
            System.out.println("Have a nice day!");
        }
    }

    public void cheeseRoom() {
        player = new GameData("1a1");
        input = new Scanner(System.in);

        System.out.println("As you enter the room, you see a box of cheese slices. Do you take one?");
        System.out.println("1. Take a cheese slice.");
        System.out.println("2. No, I'm lactose intolerant.");
        choice = input.nextInt();

        if (choice == 1) {
            items.addItem("Cheese Slice");
            cheeseRoom2();
        } else if (choice == 2) {
            System.out.println("Alright, your loss!");
            nextRoom();
        }
    }

    public void cheeseRoom2() {
        player = new GameData("1a11");
        input = new Scanner(System.in);

        System.out.println("You now have another cheese slice! Do you take another one?");
        System.out.println("1. Of course!");
        System.out.println("2. I think this is enough");
        System.out.println("3. See inventory");
        choice = input.nextInt();

        if (choice == 1) {
            items.addItem("Cheese Slice");
            cheeseRoom2();
        } else if (choice == 2) {
            System.out.println("Alright, suit yourself!");
            nextRoom();
        } else if (choice == 3) {
            items.getItems();
            cheeseRoom2();
        }
    }

    public void left() {
        player = new GameData("2a1");
        System.out.println("You Die. The End.");
    }

    public void saveProgress() {

    }

    public void nextRoom() {
        player = new GameData("1b0");
        System.out.println("You Die. The End.");
    }
}
