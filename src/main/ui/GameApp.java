package ui;

import model.GameData;
import model.GameDataList;

import java.util.Scanner;

public class GameApp {
    private Scanner input;
    private GameData player;
    private GameDataList items;
    private String playerName;

    public GameApp() {
        runGame();
    }

    public void runGame() {
        input = new Scanner(System.in);
        player = new GameData();

        System.out.println("Welcome to the game! Please enter your name.");
        playerName = input.next();
        System.out.println("Welcome, " + playerName + "! Let's get started!");
        firstSection();
    }

    public void firstSection() {

        System.out.println("You are inside a spaceship. The Captain wants you to get rid of our cargo.");
        System.out.println("The Captain said that the cargo is to the right. Which way do you go?");
        System.out.println("1. Right");
        System.out.println("2. Left");
        System.out.println("3. Save Progress");
        System.out.println("4. Quit Game");
    }
}
