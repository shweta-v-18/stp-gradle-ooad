package com.example.controller;
import com.example.services.TransactionService;
import com.example.model.Transaction;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public Transaction createTransaction(@RequestParam int userId,
                                         @RequestParam String stockSymbol,
                                         @RequestParam String transactionType,
                                         @RequestParam int quantity,
                                         @RequestParam double price) {
        return transactionService.createTransaction(userId, stockSymbol, transactionType, quantity, price);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable int userId) {
        return transactionService.getTransactionsByUser(userId);
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
