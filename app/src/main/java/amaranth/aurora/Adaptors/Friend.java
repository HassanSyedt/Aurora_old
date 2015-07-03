package amaranth.aurora.Adaptors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 6/29/2015.
 */
public class Friend {

    private String name;

    public Friend(JSONObject object){
        try {
            this.name = object.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // Factory method to convert an array of JSON objects into a list of objects
    // Friend.fromJson(jsonArray);
    public static ArrayList<Friend> fromJson(JSONArray jsonObjects) {
        ArrayList<Friend> friends = new ArrayList<Friend>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                friends.add(new Friend(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return friends;
    }

    public String getName(){
        return name;
    }
}
