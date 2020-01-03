package com.gmail.ivan200sx.metaData.ui.web;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;

import java.util.Iterator;

public class FindComponent {


    public Component findComponentWithId(HasComponents root, String id) {
        for(Component child : root) {
            if(id.equals(child.getId())) {
                // found it!
                return child;
            } else if(child instanceof HasComponents) {
                // recursively go through all children that themselves have children
                return findComponentWithId((HasComponents) child, id);
            }
        }
        // none was found
        return null;
    }


    public Component findById(HasComponents root, String id) {
        System.out.println("findById called on " + root);

        Iterator<Component> iterate = root.iterator();
        while (iterate.hasNext()) {
            Component c = iterate.next();
            if (id.equals(c.getId())) {
                return c;
            }
            if (c instanceof HasComponents) {
                Component cc = findById((HasComponents) c, id);
                if (cc != null)
                    return cc;
            }
        }

        return null;
    }





}
