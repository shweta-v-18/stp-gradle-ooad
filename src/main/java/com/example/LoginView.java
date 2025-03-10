package com.example;

import com.example.User;
import com.example.repository.UserRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("login")
public class LoginView extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;

    public LoginView() {
        TextField usernameField = new TextField("Username");
        PasswordField passwordField = new PasswordField("Password");
        Button loginButton = new Button("Login", e -> {
            User user = userRepository.findByUsername(usernameField.getValue());
            if (user != null && user.getPassword().equals(passwordField.getValue())) {
                Notification.show("Login successful!");
                getUI().ifPresent(ui -> ui.navigate("dashboard"));
            } else {
                Notification.show("Invalid credentials.");
            }
        });

        add(usernameField, passwordField, loginButton);
    }
}
