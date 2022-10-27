package ui;

import model.ItemList;
import model.GameData;
import model.Item;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;


//represents the user interface for the game utilizing the other classes for information
public class GameApp {
    private Scanner input;
    private static final String JSON_STORE = "./data/gamedata.json";
    private String playerName;
    private int choice;
    private GameData game;
    private ItemList items;
    private Item cheeseSlice;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public GameApp() {
        items = new ItemList();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        titleScreen();
    }

    public void titleScreen() {
        input = new Scanner(System.in);
        choice = 0;

        System.out.println("Hello. What would you like to do?");
        System.out.println("1. Start New Game");
        System.out.println("2. Load Saved Game");
        System.out.println("3. Close Game");

        choice = input.nextInt();

        if (choice == 1) {
            runGame();
        } else if (choice == 2) {
            loadGame();
        } else if (choice == 3) {
            System.out.println("Have a nice day!");
        } else {
            titleScreen();
        }
    }

    //EFFECTS: runs the Game application and asks player to input name
    public void runGame() {
        input = new Scanner(System.in);
        cheeseSlice = new Item("Cheese Slice", 0, 1);


        System.out.println("Welcome to the game! Please enter your name.");
        playerName = input.next();
        System.out.println("Welcome, " + playerName + "! Let's get started!");
        p0s0c0();
    }

    //EFFECTS: first section for player after inputting name
    @SuppressWarnings("methodlength") //over 25 lines long
    public void p0s0c0() {

        input = new Scanner(System.in);
        choice = 0;

        System.out.println("You are inside a spaceship. The Captain wants you to get rid of our cargo.");
        System.out.println("The Captain said that the cargo is to the right. Which way do you go?");
        System.out.println("1. Right");
        System.out.println("2. Left");
        System.out.println("3. Save Progress");
        System.out.println("4. Show Items");
        System.out.println("5. Go Back to Title Screen");
        System.out.println("6. End Game");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                p1s1c0();
                break;
            case 2:
                p2s1c0();
                break;
            case 3:
                game = new GameData("p0s0c0");
                saveGame();
                break;
            case 4:
                for (Item item : items.getItems()) {
                    System.out.println(item.getName());
                }
                p0s0c0();
                break;
            case 5:
                titleScreen();
                break;
            case 6:
                System.out.println("Have a nice day!");
                break;
            default:
                p0s0c0();
        }
    }

    //EFFECTS: choice if player goes right from p0s0c0
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void p1s1c0() {
        input = new Scanner(System.in);
        game = new GameData("p1s1c0");

        System.out.println("As you enter the room, you see a box of cheese slices. Do you take one?");
        System.out.println("1. Take a cheese slice.");
        System.out.println("2. No, I'm lactose intolerant.");
        System.out.println("3. Go Back to Title Screen");
        System.out.println("4. Save Progress");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                items.addItem(cheeseSlice);
                p1s1c1();
                break;
            case 2:
                System.out.println("Alright, your loss!");
                nextRoom();
                break;
            case 3:
                titleScreen();
                break;
            case 4:
                saveGame();
                p1s1c0();
                break;
            default:
                p1s1c0();
        }
    }

    //EFFECTS: choice if player chooses a cheese slice
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void p1s1c1() {
        input = new Scanner(System.in);
        game = new GameData("p1s1c1");

        System.out.println("Do you take another cheese slice?");
        System.out.println("1. Of course!");
        System.out.println("2. I think this is enough");
        System.out.println("3. See inventory");
        System.out.println("4. Save Progress");
        System.out.println("5. Go Back to Opening Screen");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                items.addItem(cheeseSlice);
                p1s1c1();
                break;
            case 2:
                System.out.println("Alright, suit yourself!");
                nextRoom();
                break;
            case 3:
                for (Item item : items.getItems()) {
                    System.out.println(item.getName());
                }
                p1s1c1();
                break;
            case 4:
                saveGame();
                p1s1c1();
                break;
            case 5:
                titleScreen();
            default:
                p1s1c1();
        }
    }

    //EFFECTS: saves progress and list of items collected
    private void saveGame() {
        try {
            jsonWriter.open();
            jsonWriter.write(game);
            jsonWriter.close();
            System.out.println("Game has been saved!");
        } catch (FileNotFoundException e) {
            System.out.println("Nothing is here!");
        }
    }

    private void loadGame() {
        try {
            game = jsonReader.read();
            switch (game.getProgress()) {
                case "p0s0c0":
                    p0s0c0();
                    break;
                case "p1s1c0":
                    p1s1c0();
                    break;
                case "p1s1c1":
                    p1s1c1();
                    break;
            }
        } catch (IOException e) {
            System.out.println("You do not have a saved game!");
        }
    }

    //use a switch statement to load into level

    //EFFECTS: placeholder if player goes left from p0s0c0
    public void p2s1c0() {
        System.out.println("You Die. The End.");
    }

    //EFFECTS: placeholder for later stages of game to be added later
    public void nextRoom() {
        System.out.println("You Die. The End.");
    }

}
