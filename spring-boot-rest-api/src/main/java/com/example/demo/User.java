package com.example.demo;

public class User {
  private int id;
  private String name;
  private String email;
  private String[] roles;
  private boolean admin;

  public User(int id, String name, String email, String[] roles, boolean admin) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.roles = roles;
    this.admin = admin;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String[] getRoles() {
    return roles;
  }
  public void setRoles(String[] roles) {
    this.roles = roles;
  }
  public boolean isAdmin() {
    return admin;
  }
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
}
