package com.example.bookstore.admin.controller;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private BookDao bookDao;

    @GetMapping(value = {"/admin"})
    public String layoutTest(){
        return "forward:/admin/book/all";
    }


}
