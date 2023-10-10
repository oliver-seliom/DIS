package com.example;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class JSONSaver {
  private String outputPath;
  private JSONObject obj;

  public JSONSaver(JSONObject obj, String outputPath){
    this.obj = obj;
    this.outputPath = outputPath;
  }

  public void save(){
    // Write JSONObject to a file in the project root
    try {
      FileWriter file = new FileWriter(this.outputPath);
      file.write(obj.toString(2));  // pretty print with 4-space indentation
      file.close();
      System.out.println("Successfully written JSON object to the file");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
