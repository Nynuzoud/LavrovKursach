package ru.sergey.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.sergey.common.Preferences;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
    public void saveItemAction() {
        try {
            //creating JSON Array and init JSON Object
            JSONObject jsonObject;
            JSONArray jsonArray = new JSONArray();

            double[][] array = DefaultData.getDefaultArray();


            for (int i = 0; i < array.length; i++) {
                jsonObject = new JSONObject();
                for (int j = 0; j < array[i].length; j++) {
                    jsonObject.put(String.valueOf(i) + String.valueOf(j), array[i][j]);
                }
                jsonArray.add(i, jsonObject);
            }

            FileWriter fileWriter = new FileWriter(Preferences.getPreferences.FILE_DESTINATION);
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openItemAction() {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray;
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader(Preferences.getPreferences.FILE_DESTINATION));
            JSONObject jsonObject;
            double[][] array = new double[9][14];
            for (int i = 0; i < jsonArray.size(); i++) {
                jsonObject = (JSONObject) jsonArray.get(i);
                for (int j = 0; j < jsonObject.size(); j++) {
                    array[i][j] = (double) jsonObject.get(String.valueOf(i) + String.valueOf(j));
                }
            }
            DefaultData.setDefaultArray(array);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
