package com.example;

import java.util.List;

public class Person {
  
  private String name;
  private int age;
  private Address address;
  private List<Friend> friends;

  public Person(String name, int age, Address address, List<Friend> friends) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.friends = friends;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public Address getAddress() {
    return address;
  }
  public void setAddress(Address address) {
    this.address = address;
  }
  public List<Friend> getFriends() {
    return friends;
  }
  public void setFriends(List<Friend> friends) {
    this.friends = friends;
  } 

  
}
