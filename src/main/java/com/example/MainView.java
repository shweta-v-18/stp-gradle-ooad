package com.example;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.Route;

@Route("main") // Sets this as the default route
public class MainView extends AppLayout {
    public MainView() {
        H1 title = new H1("Stock Trading Platform");
        title.getStyle().set("margin", "0").set("font-size", "1.5em");
        addToNavbar(title);

        Nav nav = new Nav();
        nav.add(new RouterLink("Dashboard", DashboardView.class));
        nav.add(new RouterLink("Login", LoginView.class));
        addToDrawer(nav);
    }
}
