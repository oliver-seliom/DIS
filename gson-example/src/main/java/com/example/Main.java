package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws IOException {
      String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/user.json")));
      Gson gson = new Gson();

      Person person = gson.fromJson(jsonContent, Person.class);

      // Print the person details
      System.out.println("Name: " + person.getName());
      System.out.println("Age: " + person.getAge());

      // Print address
      Address address = person.getAddress();
      System.out.println("Address: " + address.getStreet() + ", " + address.getCity() + ", " + address.getZip());

      // Print friends
      for (Friend friend : person.getFriends()) {
          System.out.println("Friend Name: " + friend.getName() + ", Age: " + friend.getAge());
      }
    }
}