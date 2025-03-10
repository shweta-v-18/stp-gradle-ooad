package com.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = MainView.class)
public class DashboardView extends VerticalLayout {
    public DashboardView() {
        Span welcomeText = new Span("Welcome to the Dashboard");
        Button refreshButton = new Button("Refresh Data", _ -> {
            // Add refresh logic here
        });

        add(welcomeText, refreshButton);
    }
}
