package com.example.bookstore.dao;

import com.example.bookstore.entity.CustomerOrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderBookDao extends JpaRepository<CustomerOrderBook,Integer> {
}
