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

@Route("signup")
public class SignupView extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;

    public SignupView() {
        TextField usernameField = new TextField("Username");
        TextField emailField = new TextField("Email");
        PasswordField passwordField = new PasswordField("Password");
        PasswordField confirmPasswordField = new PasswordField("Confirm Password");

        Button signupButton = new Button("Sign Up", e -> {
            if (passwordField.getValue().equals(confirmPasswordField.getValue())) {
                User user = new User();
                user.setUsername(usernameField.getValue());
                user.setEmail(emailField.getValue());
                user.setPassword(passwordField.getValue());
                userRepository.save(user); // Save to database
                Notification.show("User registered successfully!");
                getUI().ifPresent(ui -> ui.navigate("login"));
            } else {
                Notification.show("Passwords do not match.");
            }
        });

        add(usernameField, emailField, passwordField, confirmPasswordField, signupButton);
    }
}
