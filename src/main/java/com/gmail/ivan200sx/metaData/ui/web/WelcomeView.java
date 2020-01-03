package com.gmail.ivan200sx.metaData.ui.web;

import java.util.ArrayList;
import java.util.List;
import com.gmail.ivan200sx.metaData.WebWetherSgd;
import com.gmail.ivan200sx.metaData.WebWetherTts;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * @author Jevgenij Mechtijev
 * Created: 2020-01-01
 *
 */
@Route(value = "", layout = MainLayout.class)
public class WelcomeView extends VerticalLayout {

  private static final long serialVersionUID = 1L;
  public static final String VIEW_NAME = "record";
  private List<Checkbox> checkBoxes = new ArrayList<>();
  private List<Checkbox> weatherCheckBoxes = new ArrayList<>();

  public WelcomeView() {
    VerticalLayout todosList = new VerticalLayout();

    TextField taskField = new TextField();

    Button addButton = new Button("Add");
    addButton.addClickShortcut(Key.ENTER);
    addButton.addClickListener(click -> {
      if (!taskField.isEmpty()) {
        Checkbox checkbox = new Checkbox(taskField.getValue());
        checkBoxes.add(checkbox);
        todosList.add(checkbox);
        taskField.clear();
      }
    });

    Button tempButton = new Button("Check weather"); // (3)
    tempButton.addClickShortcut(Key.ENTER);
    tempButton.addClickListener(click -> {

      WebWetherTts webWetTts = new WebWetherTts();
      webWetTts.parse();
      Checkbox weatherCheckboxTts = new Checkbox("TTS (" + webWetTts.getTtsToWeb() + ")");
      todosList.add(weatherCheckboxTts);
      weatherCheckBoxes.add(weatherCheckboxTts);

      WebWetherSgd webWetSgd = new WebWetherSgd();
      webWetSgd.parse();
      Checkbox weatherCheckboxSgd = new Checkbox("SUGARDAS (" + webWetSgd.getSgdToWeb() + ")");
      todosList.add(weatherCheckboxSgd);
      weatherCheckBoxes.add(weatherCheckboxSgd);

    });


    Button deleteTempButton = new Button("Delete checked weather row");
    deleteTempButton.addClickShortcut(Key.ENTER);
    deleteTempButton.addClickListener(click -> {
      
      checkBoxes.forEach(checkbox -> {
        if(checkbox.getValue()) {

          todosList.remove(checkbox);
        }
      });
      weatherCheckBoxes.forEach(checkbox -> {
        if(checkbox.getValue()) {

          todosList.remove(checkbox);
        }
      });
      
      // Not recommended
      /*for(int i=0; i<checkBoxes.size(); i++) {
        if(!checkBoxes.get(i).getValue()) {
          
        }
      }
      
      Iterator<Checkbox> it = checkBoxes.iterator();
      while(it.hasNext()) {
        Checkbox ch = it.next();
        if(!ch.getValue()) {
          
        }
      }

      for(Checkbox ch: checkBoxes) {
        if(!ch.getValue()) {

        }

      Stream<Component> com = getChildren();
      
      com.forEach(c -> {
        if( c.getClass().equals(Checkbox.class)) {
          
        }
      });*/


    });

    add(new H1("Vaadin Todo and Weatherb START"));
    add(new HorizontalLayout(taskField, addButton, tempButton));

    add(todosList);
    todosList.add(addButton);
    todosList.add(deleteTempButton);

  }
}
