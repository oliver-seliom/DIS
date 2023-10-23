package com.example.application.views.main;

import java.util.ArrayList;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {

    private TextField name = new TextField("Your name");
    private Button sayHello = new Button("Say hello");
    private ComboBox<Country> combobox = new ComboBox("Your country is...");
    private ArrayList<Country> countries = new ArrayList<>();
    private TabSheet tabSheet = new TabSheet();

    public MainView() {
      HorizontalLayout hl = new HorizontalLayout(name, sayHello);
      hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
      
      configureCombobox();

      sayHello.addClickListener(evt -> {
        String countryName = name.getValue();
        
        addCountry(countryName);
        configureCombobox();

        Notification.show("Country " + countryName + " added successfully");
      });

      tabSheet.add("Dashboard",
        new Div(new Text("This is the Dashboard tab content")));
      
      tabSheet.add("Payment", hl);

      // Add all elements to my Main View
      add(combobox);
      // add(hl);
      add(tabSheet);

    }

    public void addCountry(String name){
      Country newCOuntry = new Country(name);
      countries.add(newCOuntry);
    }

    public void configureCombobox(){
      // Make a get request to our api

      // Let's make our comobox display the name of each country
      combobox.setItemLabelGenerator(Country::getName);

      // Let's pass the list to the combobox
      combobox.setItems(countries);
    }

}
