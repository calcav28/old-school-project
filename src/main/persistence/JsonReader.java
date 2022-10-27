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

public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public GameData read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return giveGameData(jsonObject);
    }

    private String readFile(String source) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contentBuilder.toString();
    }

    private GameData giveGameData(JSONObject jsonObject) {
        String progress = jsonObject.getString("progress");
        GameData gd = new GameData(progress);
        addItems(gd, jsonObject);
        return gd;
    }


    private void addItems(GameData gd, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(gd, nextItem);
        }
    }

    private void addItem(GameData gd, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int damage = jsonObject.getInt("damage");
        int weight = jsonObject.getInt("weight");
        Item item = new Item(name, damage, weight);
        gd.addItem(item);
    }
}
