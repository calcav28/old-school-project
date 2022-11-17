package ui;

import model.GameData;
import model.Item;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Scanner;

//json elements of file such as methods are modelled after code from WorkRoomApp in:
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

//represents the user interface for the game utilizing the other classes for information
public class GameApp extends JPanel implements ActionListener {
    private Scanner input;
    private static final String JSON_STORE = "./data/gamedata.json";
    private String playerName;
    private int choice;
    private GameData game;
    private String stage;
    private Item cheeseSlice;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JLabel questionLabel;
    private JTextField playerNameInput;
    private JTextField playerNumberInput;

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    //Starts the player at a title screen
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public GameApp() {
        super(Boolean.parseBoolean("Video Game"));
        stage = "";
        game = new GameData(stage);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        input = new Scanner(System.in);
        choice = 0;

        questionLabel = new JLabel("Hello. What would you like to do?");
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setVerticalAlignment(JLabel.TOP);

        JPanel questionPanel = new JPanel();
        questionPanel.setSize(WIDTH / 2, HEIGHT / 2);
        questionPanel.setAlignmentX(WIDTH / 2);
        questionPanel.setAlignmentY(HEIGHT / 2);
        questionPanel.add(questionLabel);

        JButton btn1 = new JButton("Start New Game");
        btn1.addActionListener(this);
        btn1.setHorizontalAlignment(JLabel.CENTER);
        btn1.setVerticalAlignment(JLabel.CENTER);
        JButton btn2 = new JButton("Load Saved Game");
        btn2.addActionListener(this);
        btn2.setHorizontalAlignment(JLabel.CENTER);
        btn2.setVerticalAlignment(JLabel.CENTER);
        JButton btn3 = new JButton("Close Game");
        btn3.addActionListener(this);
        btn3.setHorizontalAlignment(JLabel.CENTER);
        btn3.setVerticalAlignment(JLabel.CENTER);

        JPanel buttonFrame1 = new JPanel();
        buttonFrame1.setSize(200, 100);
        buttonFrame1.add(btn1);

        JPanel buttonFrame2 = new JPanel();
        buttonFrame2.setSize(200, 100);
        buttonFrame2.add(btn2);

        JPanel buttonFrame3 = new JPanel();
        buttonFrame3.setSize(200, 100);
        buttonFrame3.add(btn3);

        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Welcome to the game!");
        frame.setResizable(false);
        btn1.setActionCommand("TitleChoice1");
        btn2.setActionCommand("TitleChoice2");
        btn3.setActionCommand("TitleChoice3");
        frame.add(questionPanel, BorderLayout.NORTH);
        questionPanel.setLocation(WIDTH / 2,HEIGHT - HEIGHT);
        frame.add(buttonFrame1, BorderLayout.CENTER);
        frame.add(buttonFrame2, BorderLayout.WEST);
        frame.add(buttonFrame3, BorderLayout.EAST);
        frame.setVisible(true);
    }


    //EFFECTS: runs the Game application and asks player to input name
    public void runGame() {
        //input = new Scanner(System.in);
        cheeseSlice = new Item("Cheese Slice", 0, 1);

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("Please Input Your Name:");
        frame.setResizable(false);

        playerNameInput = new JTextField(5);
        playerNameInput.addActionListener(this);

        JButton btn1 = new JButton("Start Game");
        btn1.setActionCommand("StartGame");
        btn1.addActionListener(this);

        JPanel nameInputFrame = new JPanel();
        nameInputFrame.setSize(250, 250);
        nameInputFrame.add(playerNameInput);
        nameInputFrame.add(btn1);


        frame.add(nameInputFrame);
        frame.setVisible(true);

    }

    //EFFECTS: first section for player after inputting name
    @SuppressWarnings("methodlength") //over 25 lines long
    public void p0s0c0() {

        input = new Scanner(System.in);
        choice = 0;
        stage = "p0s0c0";
        game.setProgress(stage);

        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);

        JLabel label1 = new JLabel();
        label1.setText("You are inside a spaceship. The captain wants you to get rid of our cargo.");
        label1.setSize(25, 25);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);

        JLabel label2 = new JLabel();
        label2.setText("The Captain said that the cargo is to the right. Which way do you go?");
        label2.setSize(25, 25);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);

        JPanel labelPanel = new JPanel();
        labelPanel.setSize(WIDTH / 2, HEIGHT / 2);
        labelPanel.setLocation(100, 50);
        labelPanel.add(label1);
        labelPanel.add(label2);


        JButton btn1 = new JButton("1. Right");
        btn1.addActionListener(this);
        btn1.setActionCommand("p1s1c0");
        JPanel btn1Panel = new JPanel();
        btn1Panel.setSize(WIDTH / 10, HEIGHT / 10);
        btn1Panel.setLocation(100,100);
        btn1Panel.add(btn1);

        JButton btn2 = new JButton("2. Left");
        btn2.addActionListener(this);
        btn2.setActionCommand("p2s1c0");
        JPanel btn2Panel = new JPanel();
        btn2Panel.setSize(100, 100);
        btn2Panel.setLocation(100,200);
        btn2Panel.add(btn2);

        JButton btn3 = new JButton("3. Save Game");
        btn3.addActionListener(this);
        btn3.setActionCommand("saveGame");
        JPanel btn3Panel = new JPanel();
        btn3Panel.setSize(120, 100);
        btn3Panel.setLocation(100,300);
        btn3Panel.add(btn3);

        JButton btn4 = new JButton("4. Go Back to Title Screen");
        btn4.addActionListener(this);
        btn4.setActionCommand("titleScreen");
        JPanel btn4Panel = new JPanel();
        btn4Panel.setSize(300, 100);
        btn4Panel.setLocation(100,400);
        btn4Panel.add(btn4);

        frame.add(labelPanel);
        frame.add(btn1Panel);
        frame.add(btn2Panel);
        frame.add(btn3Panel);
        frame.add(btn4Panel);
        frame.setVisible(true);

    }

    //EFFECTS: choice if player goes right from p0s0c0
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void p1s1c0() {
        input = new Scanner(System.in);
        stage = "p1s1c0";
        game.setProgress(stage);




        System.out.println("As you enter the room, you see a box of cheese slices. Do you take one?");
        System.out.println("1. Take a cheese slice.");
        System.out.println("2. No, I'm lactose intolerant.");
        System.out.println("3. Go Back to Title Screen");
        System.out.println("4. Save Progress");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                game.addItem(cheeseSlice);
                p1s1c1();
                break;
            case 2:
                System.out.println("Alright, your loss!");
                nextRoom();
                break;
            case 3:
                runGame();
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
        stage = "p1s1c1";
        game.setProgress(stage);

        System.out.println("Do you take another cheese slice?");
        System.out.println("1. Of course!");
        System.out.println("2. I think this is enough");
        System.out.println("3. See inventory");
        System.out.println("4. Save Progress");
        System.out.println("5. Go Back to Opening Screen");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                game.addItem(cheeseSlice);
                p1s1c1();
                break;
            case 2:
                System.out.println("Alright, suit yourself!");
                nextRoom();
                break;
            case 3:
                for (Item item : game.getItems()) {
                    System.out.println(item.getName());
                }
                p1s1c1();
                break;
            case 4:
                saveGame();
                p1s1c1();
                break;
            case 5:
                runGame();
                break;
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

    //EFFECTS: reads game with saved progress and items, then goes to stage
    // depending on what progress is
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
                default:
                    System.out.println("Goodbye!");
            }
        } catch (IOException e) {
            System.out.println("You do not have a saved game!");
        }
    }

    //EFFECTS: placeholder if player goes left from p0s0c0
    public void p2s1c0() {
        System.out.println("You Die. The End.");
    }

    //EFFECTS: placeholder for later stages of game to be added later
    public void nextRoom() {
        System.out.println("You Die. The End.");
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "TitleChoice1":
                this.runGame();
                break;
            case "TitleChoice2":
                loadGame();
                break;
            case "StartGame":
                p0s0c0();
                break;
            case "p1s1c0":
                p1s1c0();
                break;
            case "p2s1c0":
                p2s1c0();
                break;
            case "saveGame":
                saveGame();
                break;
            case "titleScreen":
                new GameApp();
                break;
            default:
                System.out.println("Goodbye!");
        }
    }
}
