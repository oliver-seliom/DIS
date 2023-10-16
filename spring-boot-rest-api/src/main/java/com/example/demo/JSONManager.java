package com.example.demo;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONManager {
  public ArrayList<User> users() throws IOException{
    String projectRoot = System.getProperty("user.dir");
    String path = projectRoot + "/src/main/resources/users.json";
    String jsonContent = new String(Files.readAllBytes(Paths.get(path)));

    // Create a Gson object
    Gson gson = new Gson();

    // Since the json file returns an array, we must create its type
    Type userListType = new TypeToken<ArrayList<User>>(){}.getType();

    // Convert the JSON string to a Person object
    ArrayList<User> users = gson.fromJson(jsonContent, userListType);
    return users;
  }

  public boolean writeJsonFile(String filename, ArrayList<User>users) throws IOException{
    String projectRoot = System.getProperty("user.dir");
    String path = projectRoot + "/src/main/resources/" + filename;
    Writer writer = Files.newBufferedWriter(Paths.get(path));
    writer.write(new Gson().toJson(users));
    writer.close();
    return true;
  }
}
