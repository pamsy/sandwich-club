package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        // these fields will describa a Sandwhich
        //Name is a list of Mainname and alsoKnownAs
        final String SANDWICH_NAME = "Name";

        final String SANDWICH_MAINNAME = "mainName";
        final String SANDWICH_KNOW_AS = "alsoKnownAs";
        final String SANDWICH_ORIGIN = "placeOfOrigin";
        final String SANDWICH_DESCRIPTION = "description";
        final String SANDWICH_IMAGE = "image";
        final String SANDWICH_INGREDIENTS = "ingredients";


        String mainName;
        List<String> alsoKnownAs = null;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = null;


        /* String array to hold each sandwich's  String  that will help us to buils a Sandwhich object*/
       // Sandwich parsedSandwichData = new Sandwich();

        JSONObject sandwichJson = new JSONObject(json);

        //let's get name Json Object
        JSONObject nameJson = sandwichJson.getJSONObject(SANDWICH_NAME);

        mainName = nameJson.getString(SANDWICH_MAINNAME);

        //get alsoKnowAs
        JSONArray knowAs = nameJson.getJSONArray(SANDWICH_KNOW_AS);
        //We test if alsoKnowAs array is not empty in oder to better master our List
        if (knowAs.length()!= 0) {  // our Array is not Empty!
            for (int i=0; i < knowAs.length(); i++) {
                alsoKnownAs.add(knowAs.optString(i));
            }
        }

        placeOfOrigin = sandwichJson.getString(SANDWICH_ORIGIN);
        description = sandwichJson.getString(SANDWICH_DESCRIPTION);
        image = sandwichJson.getString(SANDWICH_IMAGE);

        //ingredient is also a list
        JSONArray ingred = sandwichJson.getJSONArray(SANDWICH_INGREDIENTS);
        if (ingred.length() != 0) {  // our Array is not Empty!
            for (int i=0; i < ingred.length(); i++) {
                ingredients.add(ingred.optString(i));
            }
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
