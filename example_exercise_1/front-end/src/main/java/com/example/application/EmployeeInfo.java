package com.example.application;

import java.util.ArrayList;

public class EmployeeInfo {
  private ArrayList<String> employeeTypes = new ArrayList<>();

  public ArrayList<String> getEmployeeTypes() {
    return employeeTypes;
  }

  public void setEmployeeTypes(ArrayList<String> employeeTypes) {
    this.employeeTypes = employeeTypes;
  }

  public EmployeeInfo(ArrayList<String> employeeTypes) {
    this.employeeTypes = employeeTypes;
  }

  

  
}
