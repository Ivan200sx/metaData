package com.gmail.ivan200sx.metaData.ui.web;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * @author Maksim Paz
 * Created: 2019-12-23
 *
 */
@Route(value = "", layout = MainLayout.class)
public class WelcomeView extends VerticalLayout {

  private static final long serialVersionUID = 1L;
  public static final String VIEW_NAME = "record";

  public WelcomeView() {
    VerticalLayout todosList = new VerticalLayout(); // (1)
    TextField taskField = new TextField(); // (2)
    Button addButton = new Button("Add"); // (3)
    addButton.addClickShortcut(Key.ENTER);
    addButton.addClickListener(click -> {
      // (4)
      Checkbox checkbox = new Checkbox(taskField.getValue());
      todosList.add(checkbox);
    });
    add( // (5)
      new H1("Vaadin Todo"),
      todosList,
      new HorizontalLayout(
        taskField,
        addButton
      )
    );
    add(new Label("OK"));
  }
}
