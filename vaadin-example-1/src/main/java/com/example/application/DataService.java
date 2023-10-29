package com.example.application;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;

public class DataService {
  public static void createProduct(Product product){
    
    HttpClient client = HttpClient.newHttpClient();

    Gson gson = new Gson();

    String body = gson.toJson(product);

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("http://localhost:8081/products"))
      .header("Content-Type", "application/json")
    
      .POST(HttpRequest.BodyPublishers.ofString(body))
      .build();
    
      try {
        client.send(request, HttpResponse.BodyHandlers.ofString());
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }
  
}
