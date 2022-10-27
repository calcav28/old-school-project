package persistence;

import model.GameData;

import org.json.JSONObject;
import java.io.*;

//Code is modelled heavily from code in JsonWriter class from:
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonWriter {
    private PrintWriter writer;
    private String destination;

    //EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public void write(GameData gd) {
        JSONObject json = gd.toJson();
        saveToFile(json.toString(5));
    }

    public void close() {
        writer.close();
    }

    public void saveToFile(String json) {
        writer.print(json);
    }
}
