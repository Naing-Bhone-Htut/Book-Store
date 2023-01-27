package com.example.bookstore.dao;

import com.example.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

    Optional<Customer> findCustomerByUsername(String username);
}
