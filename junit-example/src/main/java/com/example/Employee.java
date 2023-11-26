package com.example;

public class Employee {
  private String firstName;
  private String lastName;
  private IdGetter idService;

  public Employee(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.idService = new IdGetter();
  }

  public int getId(){
    return this.getIdService().getId(this.getFullName());
  }

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFullName(){
    return this.firstName + " " + this.lastName;
  }

  public void raiseError(int a) throws ExampleError{
    if(a == 0){
      throw new ExampleError("0 not valid");
    }
  }

  public IdGetter getIdService() {
    return idService;
  }

  public void setIdService(IdGetter idService) {
    this.idService = idService;
  }
}
