package com.gmail.ivan200sx.metaData.ui.web;

import com.gmail.ivan200sx.metaData.WebWetherSgd;
import com.gmail.ivan200sx.metaData.WebWetherTts;
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

  int idCounter;

  private static final long serialVersionUID = 1L;
  public static final String VIEW_NAME = "record";

  public WelcomeView() {
    VerticalLayout todosList = new VerticalLayout();

    TextField taskField = new TextField();

    Button addButton = new Button("Add");
    addButton.addClickShortcut(Key.ENTER);
    addButton.addClickListener(click -> {
      if (!taskField.isEmpty()) {
        Checkbox checkbox = new Checkbox(taskField.getValue());
        idCounter++;
        checkbox.setId("checkbox-" + idCounter);
        todosList.add(checkbox);
      }
    });

    Button tempButton = new Button("Check weather"); // (3)
    tempButton.addClickShortcut(Key.ENTER);
    tempButton.addClickListener(click -> {

      WebWetherTts webWetTts = new WebWetherTts();
      webWetTts.parse();
      add(new Checkbox("TTS (" + webWetTts.getTtsToWeb() + ")"));

      WebWetherSgd webWetSgd = new WebWetherSgd();
      webWetSgd.parse();
      add(new Checkbox("SUGARDAS (" + webWetSgd.getSgdToWeb() + ")"));

    });


    Button deleteTempButton = new Button("Delete weather row"); // (3)
    deleteTempButton.addClickShortcut(Key.ENTER);
    deleteTempButton.addClickListener(click -> {
      add(new Label("CLICK PERFORMS"));
      addButton.setText("Fired");
      todosList.remove(addButton);

    });

    add(new H1("Vaadin Todo and Weatherb START"));
    add(new HorizontalLayout(taskField, addButton, tempButton));

    add(todosList);
    todosList.add(addButton);
    todosList.add(deleteTempButton);

    add(new H1("Vaadin Todo and Weatherb END"));

    /*add(
            new H1("Vaadin Todo and Weatherb START"),
            new HorizontalLayout(
                    taskField,
                    addButton,
                    tempButton
            ),
            todosList,
            deleteTempButton,
            new H1("Vaadin Todo and Weather END")
    );*/
  }
}
