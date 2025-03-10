package com.example;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Route("test") // A test route for debugging
public class testview extends VerticalLayout {
    public testview() {
        add(new H1("Test View"));
    }
}
