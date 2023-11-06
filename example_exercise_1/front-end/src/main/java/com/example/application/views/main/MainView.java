package com.example.application.views.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.example.Salary;
import com.example.application.EmployeeInfo;
import com.example.application.SalaryRequestBody;
import com.google.gson.Gson;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {

    private IntegerField hoursWorked = new IntegerField();
    private IntegerField monthlySales = new IntegerField();
    private ComboBox<String> comboBox = new ComboBox<>("Employee Type");
    private Text preTaxLabel = new Text("Hello World");
    private Text postTaxLabel = new Text("");
    private Button calculatePreTax;
    private Button calculatePostTax;
    private ArrayList<String> employeeTypes = new ArrayList<>();

    public MainView() {

      try {
        getEmployeeTypes();
      } catch (IOException | InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }


      VerticalLayout preTaxVl = new VerticalLayout();
      VerticalLayout postTaxVl = new VerticalLayout();
      
      calculatePreTax = new Button("Calculate Pre tax");
      calculatePreTax.addClickListener(e -> {
        try {
          showPreTax();
        } catch (IOException | InterruptedException e1) {
          e1.printStackTrace();
          Notification.show("An error occurred");
        }
      });
      calculatePreTax.addClickShortcut(Key.ENTER);
      
      calculatePostTax = new Button("Calculate Post tax");
      calculatePostTax.addClickListener(e -> {
        try {
          showPreTax();
        } catch (IOException | InterruptedException e1) {
          e1.printStackTrace();
          Notification.show("An error occurred");
        }
      });
      calculatePostTax.addClickShortcut(Key.ENTER);
      
      preTaxVl.add(baseHorizontalLayout(), calculatePreTax, preTaxLabel);
      postTaxVl.add(baseHorizontalLayout(), calculatePostTax, postTaxLabel);


      TabSheet tabSheet = new TabSheet();
      tabSheet.add("Calculate pre tax", preTaxVl);
      tabSheet.add("Calculate post tax", postTaxVl);
      add(tabSheet);
    }

    public void getEmployeeTypes() throws IOException, InterruptedException{
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:8081/employee-types"))
        .header("Content-Type", "application/json")
        .GET()
        .build();
      
      HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

      String responseBody = response.body().toString();
      Gson gson = new Gson();
      EmployeeInfo employeeInfo = gson.fromJson(responseBody, EmployeeInfo.class);

      Notification.show(responseBody);
      employeeInfo.getEmployeeTypes().forEach(employeeType -> {
        employeeTypes.add(employeeType);
      });

    }

    public void showPreTax() throws IOException, InterruptedException{
      HttpClient client = HttpClient.newHttpClient();

      SalaryRequestBody salaryBody = new SalaryRequestBody(hoursWorked.getValue(), comboBox.getValue(), monthlySales.getValue());

      Gson gson = new Gson();
      String body = gson.toJson(salaryBody);

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:8081/pre-tax"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .build();
      
      HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
      String responseBody = response.body().toString();
      Salary salary = gson.fromJson(responseBody, Salary.class);

      preTaxLabel.setText("Pre-tax salary is " + salary.getSalary());
    }

    public HorizontalLayout baseHorizontalLayout(){
      HorizontalLayout hl = new HorizontalLayout();
      
      comboBox.setItems(employeeTypes);

      hoursWorked.setLabel("Hours worked");
      hoursWorked.setValue(0);
      hoursWorked.setStepButtonsVisible(true);
      hoursWorked.setMin(0);

      monthlySales.setLabel("Month sales");
      monthlySales.setValue(0);
      monthlySales.setStepButtonsVisible(true);
      monthlySales.setMin(0);

      hl.add(comboBox, hoursWorked, monthlySales);

      hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
      return hl;
    }

}
