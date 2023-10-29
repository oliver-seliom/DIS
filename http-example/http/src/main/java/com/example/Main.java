package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
      System.out.println("Creating user...");
      postHttpRequests();
      System.out.println("Fetching users...");
      getHttpRequest();
    }

    public static void postHttpRequests(){
      User user = new User(1, "Oliver");
      Gson gson = new Gson();
      String body = gson.toJson(user);

      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("http://localhost:3009/users"))
      .header("Content-Type", "application/json")
      .POST(HttpRequest.BodyPublishers.ofString(body))
      .build();

      try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // an example of an HTTP request that fetches users
    public static void getHttpRequest(){
      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("http://localhost:3009/users"))
          .GET()
          .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

      } catch (URISyntaxException e) {
        e.printStackTrace();
      }catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
}