package com.example.demo;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;

public class JSONManager {
  public static ArrayList<Product> readProducts() throws IOException{
    String projectRoot = System.getProperty("user.dir");
    String path = projectRoot + "/src/main/resources/products.json";

    String fileContent = new String(Files.readAllBytes(Paths.get(path)));

    Gson gson = new Gson();
    ArrayList<Product> products = gson.fromJson(fileContent, Product.productListType);
    
    return products;
  }

  public static void saveProducts(ArrayList<Product> products) throws IOException{
    Gson gson = new Gson();
    String projectRoot = System.getProperty("user.dir");
    String path = projectRoot + "/src/main/resources/products.json";
    Writer writer = Files.newBufferedWriter(Paths.get(path));
    writer.write(gson.toJson(products));
    writer.close();
  }
}
