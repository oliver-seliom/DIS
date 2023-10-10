package com.example;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    private static String projectRoot = System.getProperty("user.dir");

    public static void createAndSaveJSON(){
      JSONCreator jsonCreator = new JSONCreator();

      JSONObject json1 = jsonCreator.complexToJson();
      JSONObject json2 = jsonCreator.simpleToJson();

      // Print the JSON objects generated. They should be the same!
      System.out.println(json1.toString(4));
      System.out.println(json2.toString(4));

      String filePath = projectRoot + "/example.json";

      // Save one of the json objects to a given json file:
      JSONSaver saver = new JSONSaver(json1, filePath);
      saver.save();
    }

    public static void readAndPrintJSON(){
      // Now lets read a JSON file instead and print its contents.
      String parsePath = projectRoot + "/example2.json";
      JSONParser parser = new JSONParser(parsePath);
      JSONObject parsedObject = parser.parse();
      System.out.println(parsedObject.toString(2));

      String name = parsedObject.getString("nombre");
      JSONArray abilities = parsedObject.getJSONArray("habilidades");
      System.out.println(name + "'s abilities:");
      for (int i = 0; i < abilities.length(); i++) {
          System.out.println("- " + abilities.getString(i));
      }
    }

    public static void readAndPrintCSV(){
      // Now lets read a JSON file instead and print its contents.
      String parsePath = projectRoot + "/ejemplo.csv";

      CSVParser parser = new CSVParser(parsePath);
      List<Map<String, String>> list = parser.parse();
      for (Map<String,String> record : list) {
        System.out.println(record.get("ID"));
        System.out.println(record.get("Name"));
        System.out.println(record.get("Age"));
        System.out.println(record.get("Occupation"));
        System.out.println(record.get("Email"));
        System.out.println("-------");
      }
    }

    public static void main(String[] args) {
      // createAndSaveJSON();
      // readAndPrintJSON();
      readAndPrintCSV();
    }
}