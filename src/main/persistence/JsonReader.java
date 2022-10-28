package persistence;

import model.GameData;
import model.Item;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//Code is modelled heavily from code in JsonReader class from:
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

//represents reader that reads gamedata from JSON source
public class JsonReader {
    private String source;

    //EFFECTS: constructs a reader that will read from a source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads contents of gamedata file and returns it;
    // if error in reading file, will throw IOException
    public GameData read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return giveGameData(jsonObject);
    }

    //EFFECTS: reads file from source and returns it as string
    private String readFile(String source) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contentBuilder.toString();
    }

    //EFFECTS: gets gamedata from JSON object and returns it
    private GameData giveGameData(JSONObject jsonObject) {
        String progress = jsonObject.getString("progress");
        GameData gd = new GameData(progress);
        addItems(gd, jsonObject);
        return gd;
    }


    //MODIFIES: gd
    //EFFECTS: goes through items from JSON objects and adds them to gamedata
    private void addItems(GameData gd, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(gd, nextItem);
        }
    }

    //MODIFIES: gd
    //EFFECTS: goes through item contents in JSON object and adds it to gamedata
    private void addItem(GameData gd, JSONObject jsonObject) {
        String name = jsonObject.getString("itemName");
        int damage = jsonObject.getInt("itemDamage");
        int weight = jsonObject.getInt("itemWeight");
        Item item = new Item(name, damage, weight);
        gd.addItem(item);
    }
}
