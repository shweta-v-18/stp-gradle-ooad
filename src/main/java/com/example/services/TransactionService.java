package com.example.services;

import com.example.model.Transaction;
import com.example.repository.TransactionRepository;
import com.example.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    // Constructor injection
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    // Create a transaction
    public Transaction createTransaction(int userId, String stockSymbol, String transactionType, int quantity, double price) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setStockSymbol(stockSymbol);
        transaction.setTransactionType(transactionType);
        transaction.setQuantity(quantity);
        transaction.setPrice(price);
        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);  // Save transaction to DB
    }

    // Get all transactions for a specific user
    public List<Transaction> getTransactionsByUser(int userId) {
        return transactionRepository.findByUserId(userId);  // Fetch by userId
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();  // Fetch all transactions
    }
}
