package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JSONParser {
  private String path;

  public JSONParser(String path){
    this.path = path;
  }

  public JSONObject parse(){
    try {
      String content = new String(Files.readAllBytes(Paths.get(this.path)));
      JSONObject jsonObject = new JSONObject(content);
      return jsonObject;

    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
    return null;
  }
}
