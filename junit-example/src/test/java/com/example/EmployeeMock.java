package com.example;

public class EmployeeMock extends Employee {

  public EmployeeMock(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public int getId(){
    System.out.println("Does not call API");
    return 2;
  }
  
}
