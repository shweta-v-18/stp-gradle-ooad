package com.example;

import com.example.model.Transaction;
import com.example.services.TransactionService;
import com.example.User;
import com.example.repository.UserRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import com.vaadin.flow.router.Route;

@Route("add-transaction")
public class TransactionForm extends VerticalLayout {

    private final TransactionService transactionService;
    private final UserRepository userRepository;

    // Form fields
    private TextField stockSymbol = new TextField("Stock Symbol");
    private TextField transactionType = new TextField("Transaction Type");
    private TextField quantity = new TextField("Quantity");
    private TextField price = new TextField("Price");

    // Constructor
    @Autowired
    public TransactionForm(TransactionService transactionService, UserRepository userRepository) {
        this.transactionService = transactionService;
        this.userRepository = userRepository;

        // Set up form layout
        FormLayout formLayout = new FormLayout(stockSymbol, transactionType, quantity, price);
        Button submitButton = new Button("Submit", e -> saveTransaction());

        add(formLayout, submitButton);
    }

    // Save the transaction to the database
    private void saveTransaction() {
        try {
            // Get form field values
            String symbol = stockSymbol.getValue();
            String type = transactionType.getValue();
            int qty = Integer.parseInt(quantity.getValue());
            double transactionPrice = Double.parseDouble(price.getValue());

            // Get the current logged-in user
            String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepository.findByUsername(loggedInUsername);
            int userId = user.getId();  // Assuming user has an id field

            // Call the service to create the transaction
            transactionService.createTransaction(userId, symbol, type, qty, transactionPrice);

            Notification.show("Transaction added successfully!");
        } catch (NumberFormatException e) {
            Notification.show("Please enter valid data.");
        }
    }
}
