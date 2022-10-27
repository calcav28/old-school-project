package persistence;

import org.json.JSONObject;

//code is modelled after Writable interface in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public interface Writable {
    JSONObject toJson();
}
