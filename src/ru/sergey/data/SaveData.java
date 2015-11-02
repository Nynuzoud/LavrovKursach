package ru.sergey.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class SaveData {
    public void saveItemAction() {

        //creating JSON Array and init JSON Object
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;

        for(HashMap<String, Double> hashMap : DefaultData.getDefaultArrayList()) {
            int currentFurnace = 1;
            jsonObject = new JSONObject();
            jsonObject.put("rashodPGBase"+currentFurnace, hashMap.get("rashodPGBase"+currentFurnace));
            jsonObject.put("minRashodPG", hashMap.get("minRashodPG"));
            jsonObject.put("maxRashodPG", hashMap.get("maxRashodPG"));
            jsonObject.put("rezervPG", hashMap.get("rezervPG"));
            jsonObject.put("zapasKoks", hashMap.get("zapasKoks"));
            jsonObject.put("trebProizvChug", hashMap.get("trebProizvChug"));
            jsonObject.put("sodSiChugBase"+currentFurnace, hashMap.get("sodSiChugBase"+currentFurnace));
            jsonObject.put("minSi", hashMap.get("minSi"));
            jsonObject.put("maxSi", hashMap.get("maxSi"));
        }
    }
}
