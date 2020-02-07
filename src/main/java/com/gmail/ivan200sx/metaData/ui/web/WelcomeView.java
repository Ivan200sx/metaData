package com.gmail.ivan200sx.metaData.ui.web;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import com.gmail.ivan200sx.metaData.sheduler.ScheduledLoader;
import com.vaadin.flow.router.PreserveOnRefresh;
import org.springframework.beans.factory.annotation.Autowired;
import com.gmail.ivan200sx.metaData.WebWetherSgd;
import com.gmail.ivan200sx.metaData.WebWetherTts;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Jevgenij Mechtijev
 * Created: 2020-01-01
 *
 */
@Route(value = "", layout = MainLayout.class)
//@PreserveOnRefresh
public class WelcomeView extends VerticalLayout {

  Integer counter = 0;
  private static final long serialVersionUID = 1L;
  public static final String VIEW_NAME = "record";
  private ScheduledLoader scheduledLoader;
  private TextField ttsTempField = new TextField("TTS");
  private TextField sgdTempField = new TextField("Sugardas");

  @Autowired
  public WelcomeView(WebWetherTts webWetTts, WebWetherSgd webWetSgd,
      ScheduledLoader scheduledLoader) {
    this.scheduledLoader = scheduledLoader;

    add(ttsTempField, sgdTempField);
  }

  @Scheduled(fixedRate = 1000)
  public void runLoader() {
    counter++;
    System.out.println("Request..." + counter);
    ttsTempField.setValue(scheduledLoader.getLastTtsTemp() + "-test");
  }
}
