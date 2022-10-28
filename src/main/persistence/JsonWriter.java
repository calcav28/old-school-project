package persistence;

import model.GameData;

import org.json.JSONObject;
import java.io.*;

//Code is modelled heavily from code in JsonWriter class from:
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

//Represents a writer that will write a JSON representation of gamedata to file
public class JsonWriter {
    private PrintWriter writer;
    private String destination;

    //EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    //MODIFIES: this
    //EFFECTS: opens the writer;
    //if file cannot be found, will throw FileNotFoundException
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    //MODIFIES: this
    //EFFECTS: writes the JSON representation of gamedata
    public void write(GameData gd) {
        JSONObject json = gd.toJson();
        saveToFile(json.toString(5));
    }

    //MODIFIES: this
    //EFFECTS: closes the writer
    public void close() {
        writer.close();
    }

    //MODIFIES: this
    //EFFECTS: writes given string 
    public void saveToFile(String json) {
        writer.print(json);
    }
}
