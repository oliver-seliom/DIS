package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

  private EmployeeMock employee;

  @Before
  public void setup(){
    this.employee = new EmployeeMock("Oliver", "Hoffman");
  }

  @After
  public void clear(){

  }

  @Test
  public void testGetFullName() {
    assertEquals(this.employee.getFullName(), "Oliver Hoffman");
  }

  @Test
  public void testSetFirstName() {
    this.employee.setFirstName("Alex");
    assertTrue(this.employee.getFirstName().equals("Alex"));
  }
  
  @Test(expected = ExampleError.class)
  public void testRaiseErrorWith0() throws ExampleError {
    this.employee.raiseError(0);
  }

  @Test
  public void testRaiseErrorWith1() throws ExampleError{
    this.employee.raiseError(1);
  }

  @Test
  public void testFail(){
    //fail("Hello");
  }

  @Test
  public void testGetId(){
    this.employee.getId();
  }
}
