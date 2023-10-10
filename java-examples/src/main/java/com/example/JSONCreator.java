package com.example;

import org.json.JSONObject;

/*
 * This class creates a JSON object.
 * Note: You probably do not need to be creating classes like Address or Person
 * for basic operations like these. They are just for illustrative purposes.
 {
    "name": "John Doe",
    "address": {
      "city": "Springfield",
      "zip": "12345",
      "street": "123 Elm Street"
    },
    "phoneNumbers": [
      "123-456-7890",
      "987-654-3210"
    ],
    "age": 30
  }
 */
public class JSONCreator {
  private class Address {
    private String city;
    private String zip;
    private String street;

    public Address(String city, String street, String zip){
      this.city = city;
      this.street = street;
      this.zip = zip;
    }

    public JSONObject toJson() {
      JSONObject rootJsonObject = new JSONObject();
      rootJsonObject.put("city", this.city);
      rootJsonObject.put("zip", this.zip);
      rootJsonObject.put("street", this.street);
      return rootJsonObject;
    }
  }

  private class Person {
    private String name;
    private int age;
    private String[] phoneNumbers;
    private Address address;

    public Person(String name, int age, String[] phoneNumbers, Address address){
      this.name = name;
      this.age = age;
      this.phoneNumbers = phoneNumbers;
      this.address = address;
    }

    public JSONObject toJson() {
      JSONObject rootJsonObject = new JSONObject();
      rootJsonObject.put("name", this.name);
      rootJsonObject.put("address", address.toJson());
      rootJsonObject.put("phoneNumbers", this.phoneNumbers);
      rootJsonObject.put("age", this.age);
      return rootJsonObject;
    }
  }

  public JSONCreator(){
    
  }

  public JSONObject complexToJson(){
    Address address = new Address("Springfield", "13 Elm Street", "12345");
    String[] phoneNumbers = {"123-456-7890", "987-654-3210"};
    Person person = new Person("John Doe", 30, phoneNumbers, address);
    return person.toJson();
  }

  public JSONObject simpleToJson(){
    JSONObject rootJsonObject = new JSONObject();
    
    JSONObject address = new JSONObject();
    address.put("city", "Springfield");
    address.put("street", "13 Elm Street");
    address.put("zip", "12345");

    String[] phoneNumbers = {"123-456-7890", "987-654-3210"};

    rootJsonObject.put("name", "John Doe");
    rootJsonObject.put("address", address);
    rootJsonObject.put("phoneNumbers", phoneNumbers);
    rootJsonObject.put("age", 30);

    return rootJsonObject;
  }
}
