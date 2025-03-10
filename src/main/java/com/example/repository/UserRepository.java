package com.example.repository;

import com.example.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom method to find a user by their username
    User findByUsername(String username);
}
