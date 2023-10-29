package com.example.application.views.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.example.application.data.Company;
import com.example.application.data.Contact;
import com.example.application.data.Status;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("allContacts List")
@Route(value = "")
public class ListView extends VerticalLayout {

    ArrayList<Contact> allContacts = new ArrayList<Contact>();

    // Creating a button
    Button button = new Button("Click me");

    // Creating a text input
    TextField name = new TextField("Name");

    // Creating a table.
    Grid<Contact> grid = new Grid<>(Contact.class);

    // Creating a form
    ContactForm form = createForm();

    // This is the main view of my page
    public ListView() {
      // This will act as our database
      allContacts.add(new Contact("Oliver", "Hoffman", new Company("Apple"), new Status("Allowed"), "oliver@ufv.es"));

      name.setPlaceholder("Filter by name...");
      name.setClearButtonVisible(true);
      name.setValueChangeMode(ValueChangeMode.LAZY);
      name.addValueChangeListener(event->updateGrid());
      // Add an event listener so that when a user clicks,
      // a notification is shown.
      button.addClickListener(click -> {
        Notification.show("Hello "+ name.getValue());
      });
      
      // Creating a horizontal layout so the input and the button are next to each other
      HorizontalLayout hl = new HorizontalLayout(name, button);
      hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);

      // Add the horizontal layout to my main view
      add(hl);

      // Let's make our main view expand all the way to the bottom and right.
      setSizeFull();

      configureGrid();
      updateGrid();

      HorizontalLayout hl2 = new HorizontalLayout(grid, form);
      hl2.setFlexGrow(2, grid);
      hl2.setFlexGrow(1, form);
      hl2.setSizeFull();
      add(hl2);

      form.addClickListener(e->Notification.show(e.toString()));
      
    }

    // We don't want to clutter the main view with a bunch of elements, so let's abstract some 
    // of the functionality in other methods. In this case, we update the Grid (Table) that maps
    // to the Contact class.
    public void configureGrid(){
      
      // Let's make the grid inherit the size of its parent.
      grid.setSizeFull();

      /* ************************
        Let's define the columns that the grid will have, and map them to the attributes
        of the Contact class 
      **************************/
      grid.setColumns("firstName", "lastName", "email");
      
      // This column's header will be the status of the contact
      grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");

      // This column's header will be Company name, so it will display the name of the company of the contact.
      grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company Name");

      // Give each column a good default width
      grid.getColumns().forEach(column->column.setAutoWidth(true));
    }

    public void updateGrid(){
      ArrayList<Contact> filteredContacts = new ArrayList<Contact>();
      allContacts.forEach(contact->{
        if(contact.getFirstName().toLowerCase().contains(name.getValue().toLowerCase())){
          filteredContacts.add(contact);
        }
      });
      grid.setItems(filteredContacts);
      
    }

    // Lets add a form to manage the creation of a contact
    public ContactForm createForm(){
      ArrayList<Company> companies = new ArrayList<>();
      companies.add(new Company("Apple"));
      companies.add(new Company("Microsoft"));
      ContactForm form = new ContactForm(companies, Collections.emptyList());
      form.setWidth("25em");
      return form;
    }

}
