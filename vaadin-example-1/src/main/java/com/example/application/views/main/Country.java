package com.example.application.views.main;

public class Country {
  private String name;
  private String continent;

  public Country(String name, String continent) {
    this.name = name;
    this.continent = continent;
  }

  public Country(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }
  
}
