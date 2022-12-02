package ui;

import model.GameData;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import model.Item;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

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
    private JList list;
    private DefaultListModel listModel;
    private BufferedImage img;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;



    //Starts the player at a title screen
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public GameApp() {
        super(Boolean.parseBoolean("Video Game"));
        stage = "";
        game = new GameData(stage);
        cheeseSlice = new Item("Cheese Slice", 0, 1);

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
        questionPanel.setLocation(WIDTH / 2, 0);
        frame.add(buttonFrame1, BorderLayout.CENTER);
        frame.add(buttonFrame2, BorderLayout.WEST);
        frame.add(buttonFrame3, BorderLayout.EAST);
        frame.setVisible(true);
    }


    //EFFECTS: runs the Game application and asks player to input name
    public void runGame() {
        //input = new Scanner(System.in);

        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
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
        label1.setText("You are inside a spaceship. "
                + "The captain wants you to get rid of our cargo. Do you go left or right?");
        label1.setSize(25, 25);
        JLabel label2 = new JLabel();
        label2.setText("The Captain said that the cargo is to the right. Which way do you go?");
        label2.setSize(25, 25);

        JPanel labelPanel = new JPanel();
        labelPanel.setBounds(0, 0, WIDTH, HEIGHT);
        labelPanel.add(label1, BorderLayout.NORTH);
        labelPanel.add(label2, BorderLayout.SOUTH);


        JButton btn1 = new JButton("Right");
        btn1.addActionListener(this);
        btn1.setActionCommand("p1s1c0");
        JPanel btn1Panel = new JPanel();
        btn1Panel.setBounds(WIDTH / 10, HEIGHT / 10, WIDTH, HEIGHT);
        btn1Panel.add(btn1);

        JButton btn2 = new JButton("Left");
        btn2.addActionListener(this);
        btn2.setActionCommand("p2s1c0");
        JPanel btn2Panel = new JPanel();
        btn2Panel.setSize(WIDTH / 10, HEIGHT / 10);
        btn2Panel.setLocation(100, 200);
        btn2Panel.add(btn2);

        JButton btn3 = new JButton("Save Game");
        btn3.addActionListener(this);
        btn3.setActionCommand("saveGame");
        JPanel btn3Panel = new JPanel();
        btn3Panel.setSize(WIDTH / 9, HEIGHT / 9);
        btn3Panel.setLocation(100, 300);
        btn3Panel.add(btn3);

        JButton btn4 = new JButton("Go Back to Title Screen");
        btn4.addActionListener(this);
        btn4.setActionCommand("titleScreen");
        JPanel btn4Panel = new JPanel();
        btn4Panel.setBounds(WIDTH / 5, HEIGHT / 5, WIDTH / 10, HEIGHT / 10);
        btn4Panel.add(btn4);

        frame.add(labelPanel, BorderLayout.PAGE_START);
        frame.add(btn1Panel, BorderLayout.EAST);
        frame.add(btn2Panel, BorderLayout.WEST);
        frame.add(btn3Panel, BorderLayout.CENTER);
        frame.add(btn4Panel, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

    //EFFECTS: choice if player goes right from p0s0c0
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void p1s1c0() {
        input = new Scanner(System.in);
        stage = "p1s1c0";
        game.setProgress(stage);
        listModel = new DefaultListModel();

        ImageIcon icon = new ImageIcon("src/main/ui/images/icon.jpg");

        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        JLabel imgLabel = new JLabel();
        imgLabel.setSize(800, 800);
        imgLabel.setIcon(icon);
        imgLabel.setLayout(new BorderLayout());
        imgLabel.setOpaque(true);
        frame.setContentPane(imgLabel);

        JLabel label1 = new JLabel();
        label1.setText("As you enter the room, you see a box of cheese. Do you take one?");
        label1.setSize(25, 25);
        JPanel labelPanel = new JPanel();
        labelPanel.setBounds(0, 0, WIDTH, HEIGHT);
        labelPanel.add(label1);

        JButton btn1 = new JButton("Yes!");
        btn1.addActionListener(this);
        btn1.setActionCommand("p1s1c1");
        JPanel btn1Panel = new JPanel();
        btn1Panel.setBounds(WIDTH / 10, HEIGHT / 10, WIDTH, HEIGHT);
        btn1Panel.add(btn1);

        JButton btn2 = new JButton("I'm Good");
        btn2.addActionListener(this);
        btn2.setActionCommand("p2s1c0");
        JPanel btn2Panel = new JPanel();
        btn2Panel.setSize(WIDTH / 10, HEIGHT / 10);
        btn2Panel.setLocation(100, 200);
        btn2Panel.add(btn2);

        JButton btn4 = new JButton("Go Back to Title Screen");
        btn4.addActionListener(this);
        btn4.setActionCommand("titleScreen");

        JButton btn3 = new JButton("Save Game");
        btn3.addActionListener(this);
        btn3.setActionCommand("saveGame");
        JPanel btn3Panel = new JPanel();
        btn3Panel.setSize(WIDTH / 5, HEIGHT / 5);
        btn3Panel.setLocation(100, 300);
        btn3Panel.add(btn3);
        btn3Panel.add(btn4);


        //JPanel btn4Panel = new JPanel();
        //btn4Panel.setBounds(WIDTH / 5, HEIGHT / 5, WIDTH / 10, HEIGHT / 10);
        //btn4Panel.add(btn4);

        frame.add(labelPanel, BorderLayout.PAGE_START);
        frame.add(btn1Panel, BorderLayout.EAST);
        frame.add(btn2Panel, BorderLayout.WEST);
        frame.add(btn3Panel, BorderLayout.PAGE_END);
        //frame.add(btn4Panel, BorderLayout.PAGE_END);
        frame.setVisible(true);

    }

    //EFFECTS: choice if player chooses a cheese slice
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void p1s1c1() {
        input = new Scanner(System.in);
        stage = "p1s1c1";
        game.setProgress(stage);
        game.addItem(cheeseSlice);

        ImageIcon icon = new ImageIcon("src/main/ui/images/icon.jpg");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                for (model.Event ev : EventLog.getInstance()) {
                    System.out.println(ev.toString() + "\n");
                }
                System.exit(0);
            }
        });
        frame.setSize(WIDTH, HEIGHT);
        JLabel imgLabel = new JLabel();
        imgLabel.setSize(400, 400);
        imgLabel.setIcon(icon);
        imgLabel.setLayout(new BorderLayout());
        imgLabel.setOpaque(false);
        frame.setContentPane(imgLabel);

        JLabel label1 = new JLabel();
        label1.setText("Do you take another one?");
        label1.setSize(25, 25);
        JPanel labelPanel = new JPanel();
        labelPanel.setBounds(0, 0, WIDTH, HEIGHT);
        labelPanel.add(label1);


        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setSize(200, 200);
        listScrollPane.setVisible(true);

        JPanel listPanel = new JPanel();
        listPanel.setSize(250, 250);
        listPanel.add(listScrollPane);

        JButton btn1 = new JButton("Yes!");
        btn1.addActionListener(this);
        btn1.setActionCommand("p1s1c1");
        JPanel btn1Panel = new JPanel();
        btn1Panel.setBounds(WIDTH / 10, HEIGHT / 10, WIDTH, HEIGHT);
        btn1Panel.add(btn1);

        JButton btn2 = new JButton("I'm Good");
        btn2.addActionListener(this);
        btn2.setActionCommand("p2s1c0");
        JPanel btn2Panel = new JPanel();
        btn2Panel.setSize(WIDTH / 10, HEIGHT / 10);
        btn2Panel.setLocation(100, 200);
        btn2Panel.add(btn2);

        JButton btn3 = new JButton("Save Game");
        btn3.addActionListener(this);
        btn3.setActionCommand("saveGame");
        JPanel btn3Panel = new JPanel();
        btn3Panel.setSize(WIDTH / 9, HEIGHT / 9);
        btn3Panel.setLocation(100, 300);
        btn3Panel.add(btn3);

        JButton btn4 = new JButton("Go Back to Title Screen");
        btn4.addActionListener(this);
        btn4.setActionCommand("titleScreen");
        JPanel btn4Panel = new JPanel();
        btn4Panel.setBounds(WIDTH / 5, HEIGHT / 5, WIDTH / 10, HEIGHT / 10);
        btn4Panel.add(btn4);

        JButton btn5 = new JButton("Clear Inventory");
        btn5.addActionListener(this);
        btn5.setActionCommand("clearInventory");
        JPanel btn5Panel = new JPanel();
        btn5Panel.setBounds(WIDTH / 6, HEIGHT / 6, WIDTH / 10, HEIGHT / 10);
        btn5Panel.add(btn3);
        btn5Panel.add(btn4);
        btn5Panel.add(btn5);

        frame.add(labelPanel, BorderLayout.PAGE_START);
        frame.add(btn1Panel, BorderLayout.EAST);
        frame.add(btn2Panel, BorderLayout.WEST);
        //frame.add(btn3Panel, BorderLayout.CENTER);
        //frame.add(btn4Panel, BorderLayout.SOUTH);
        frame.add(btn5Panel, BorderLayout.PAGE_END);
        frame.add(listPanel);
        frame.setVisible(true);

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
            listModel = new DefaultListModel();
            for (int i = game.itemsSize(); i > 0; i--) {
                listModel.addElement(cheeseSlice.getName());
            }
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

    //EFFECTS: runs appropriate code based on button pressed
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "TitleChoice1":
                p0s0c0();
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
            case "p1s1c1":
                listModel.addElement(cheeseSlice.getName());
                p1s1c1();
                break;
            case "clearInventory":
                listModel.clear();
                game.clearItems();
                p1s1c1();
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

