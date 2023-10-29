package com.example.application.views.main;

public class Country {

  class City {
    private String name;

    public City(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
  
  private String name;
  private String continent;
  private City capitalCity;

  public Country(String name, String continent, String capitalCity) {
    this.name = name;
    this.continent = continent;
    this.capitalCity = new City(capitalCity);
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

  public City getCapitalCity() {
    return capitalCity;
  }

  public void setCapitalCity(City capitalCity) {
    this.capitalCity = capitalCity;
  }

  

  
  
}
