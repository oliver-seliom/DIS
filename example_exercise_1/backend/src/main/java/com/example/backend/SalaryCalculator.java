package com.example.backend;

public class SalaryCalculator {
  public static Double BASE_MANAGER_SALARY = 2000.0;
  public static Double BASE_SELLER_SALARY = 1000.0;

  public static Double BASE_MANAGER_EXTRA_HOURS_BONUS = 100.0;
  public static Double BASE_SELLER_EXTRA_HOURS_BONUS = 50.0;

  public static Double calculatePreTax(SalaryRequestBody body){
    Double salary = 0.0;

    if(body.getEmployeeType().equals("manager")){
      salary = BASE_MANAGER_SALARY;
      salary += (body.getHoursWorked() * BASE_MANAGER_EXTRA_HOURS_BONUS);
    } else {
      salary = BASE_SELLER_SALARY;
      salary += (body.getHoursWorked() * BASE_SELLER_EXTRA_HOURS_BONUS);
    }

    if(body.getNumberOfSales() >= 1000 && body.getNumberOfSales() < 1500){
      salary += 100.0;
    }

    if(body.getNumberOfSales() > 1500){
      salary += 200.0;
    }

    return salary;
  }

  public static Double calcultePostTax(SalaryRequestBody body){
    Double salary = calculatePreTax(body);
    if(salary <= 1000){
      return salary;
    }

    if(salary >= 1000 && salary < 1500){
      return salary - (salary * 0.16);
    } else {
      return salary - (salary * 0.18);
    }
  }
}
