package com.example.demo;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

public class Product {
  private int id;
  private String name;
  private float price;

  public static Type productListType = new TypeToken<ArrayList<Product>>(){}.getType();

  public Product(int id, String name, float price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  

  
}
