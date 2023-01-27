package com.example.bookstore.controller;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.dao.CustomerDao;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
public class AccountController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ModelAttribute("books")
    public List<Book> bookList(){
        return bookDao.findAll();
    }


}
