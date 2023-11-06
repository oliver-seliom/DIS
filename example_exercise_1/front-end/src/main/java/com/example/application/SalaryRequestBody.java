package com.example.application;

public class SalaryRequestBody {
  private int hoursWorked;
  private String employeeType;
  private int numberOfSales;
  
  public int getHoursWorked() {
    return hoursWorked;
  }
  public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
  }
  public String getEmployeeType() {
    return employeeType;
  }
  public void setEmployeeType(String employeeType) {
    this.employeeType = employeeType;
  }
  public int getNumberOfSales() {
    return numberOfSales;
  }
  public void setNumberOfSales(int numberOfSales) {
    this.numberOfSales = numberOfSales;
  }

  public SalaryRequestBody(int hoursWorked, String employeeType, int numberOfSales) {
    this.hoursWorked = hoursWorked;
    this.employeeType = employeeType;
    this.numberOfSales = numberOfSales;
  }

  
}

