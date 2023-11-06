package com.example.backend;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
  @PostMapping("/pre-tax")
  public Salary calculatePreTax(@RequestBody SalaryRequestBody body){
    Salary salary = new Salary(SalaryCalculator.calculatePreTax(body));
    return salary;
  }

  @PostMapping("/post-tax")
  public Salary calculatePostTax(@RequestBody SalaryRequestBody body){
    Salary salary = new Salary(SalaryCalculator.calcultePostTax(body));
    return salary;
  }

  @GetMapping("/employee-types")
  public HashMap<String, ArrayList<String>> employeTypes(){
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    ArrayList<String> employeeTypes = new ArrayList<>();
    employeeTypes.add("manager");
    employeeTypes.add("seller");

    map.put("employeeTypes", employeeTypes);
    return map;
  }
}
