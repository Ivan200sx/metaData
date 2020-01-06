package com.gmail.ivan200sx.metaData.ui.web;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.internal.BeforeEnterHandler;
import com.vaadin.flow.server.VaadinServletService;
import com.vaadin.flow.server.VaadinSession;

/**
 * @author Maksim Paz
 * Created: 2019-12-23
 *
 */
public class Menu  extends FlexLayout implements BeforeEnterHandler {
  private static final long serialVersionUID = 1L;
  private Tabs tabs;
  private static final String SHOW_TABS = "show-tabs";
  private List<String> displayedViews = new ArrayList<>();
  public Menu() {
    setClassName("menu-bar");
    // Button for toggling the menu visibility on small screens
    final Button showMenu = new Button("Menu", event -> {
        if (tabs.getClassNames().contains(SHOW_TABS)) {
            tabs.removeClassName(SHOW_TABS);
        } else {
            tabs.addClassName(SHOW_TABS);
        }
    });
    showMenu.setClassName("menu-button");
    showMenu.addThemeVariants(ButtonVariant.LUMO_SMALL);
    showMenu.setIcon(new Icon(VaadinIcon.MENU));
    add(showMenu);

    // header of the menu
    final HorizontalLayout top = new HorizontalLayout();
    top.setDefaultVerticalComponentAlignment(Alignment.CENTER);
    top.setClassName("menu-header");

    Label title = new Label("Meta Info");
    title.getStyle().set("font-weight", "bold").set("color", "gray");

    // Note! Image resource url is resolved here as it is dependent on the
    // execution mode (development or production) and browser ES level support

    String resolvedImage = VaadinServletService.getCurrent()
            .resolveResource("img/logo.png",
                    VaadinSession.getCurrent().getBrowser());

    Image image = new Image(resolvedImage, "");
    image.getStyle().set("width", "40px");
    top.add(image);
    top.add(title);
    add(top);

 // container for the navigation buttons, which are added by addView()
    tabs = new Tabs();
    tabs.setOrientation(Tabs.Orientation.VERTICAL);
    setFlexGrow(1, tabs);
    add(tabs);

  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    removeAll();
    //menuBar.addItem(employeeNum).add(new Icon(VaadinIcon.USER));
  }

  /**
   * Add a view to the navigation menu
   *
   * @param viewClass
   *         that has a {@code Route} annotation
   * @param caption
   *         view caption in the menu
   * @param icon
   *         view icon in the menu
   */
  public void addView(Class<? extends Component> viewClass, String caption,
          Icon icon) {

      if(!displayedViews.contains(caption)) {
        displayedViews.add(caption);
        Tab tab = new Tab();
        RouterLink routerLink = new RouterLink(null, viewClass);
        routerLink.setClassName("menu-link");
        routerLink.add(icon);
        Span cpt = new Span("" + caption);
        cpt.getStyle().set("margin-left", "10px");
        routerLink.add(cpt);

        tab.add(routerLink);
        tabs.add(tab);
      }
  }
}