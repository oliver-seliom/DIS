package com.example.application.views.list;

import java.util.List;

import com.example.application.data.Company;
import com.example.application.data.Status;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class ContactForm extends FormLayout {
  public ContactForm(List<Company> companies, List<Status> statuses){
    TextField name = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");

    ComboBox<Status> status = new ComboBox<>("Status");
    status.setItems(statuses);
    status.setItemLabelGenerator(Status::getName);

    ComboBox<Company> company = new ComboBox<>("Company");
    company.setItems(companies);
    company.setItemLabelGenerator(Company::getName);

    add(name, lastName, email, status, company, createButtonLayout());

  }

  public Component createButtonLayout(){
    Button save = new Button("Save");
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    save.addClickShortcut(Key.ENTER);

    Button delete = new Button("Delete");
    delete.addThemeVariants(ButtonVariant.LUMO_ERROR);

    Button cancel = new Button("Cancel");
    cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    save.addClickShortcut(Key.ESCAPE);

    return new HorizontalLayout(save, delete, cancel);
  }
}
