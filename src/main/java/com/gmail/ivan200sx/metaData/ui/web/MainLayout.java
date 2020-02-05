package com.gmail.ivan200sx.metaData.ui.web;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;

@Theme(Material.class)
@PWA(name = "Flex MetaInfo impl...", shortName = "MetaInfo")
@CssImport("./styles/shared-styles.css")
public class MainLayout extends FlexLayout implements RouterLayout {

  private static final long serialVersionUID = 1L;

  private Menu menu;

  public MainLayout() {
    System.out.println("> > >  MainLayout < < < < ");
    setSizeFull();
    setClassName("main-layout");

    menu = new Menu();
    menu.addView(WelcomeView.class, "Welcome", VaadinIcon.NEWSPAPER.create());
    add(menu);
    
  }
}