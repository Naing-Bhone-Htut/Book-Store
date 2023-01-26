package com.example.bookstore.admin.controller;

import com.example.bookstore.dao.AuthorDao;
import com.example.bookstore.dao.BookDao;
import com.example.bookstore.dao.CategoryDao;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private CategoryDao categoryDao;


    @GetMapping("/book-form")
    public String bookForm(Model model){
        model.addAttribute("authors",authorDao.findAll());
        model.addAttribute("categories",categoryDao.findAll());
        model.addAttribute("book",new Book());
        return "admin/book-form";
    }

    //https://source.unsplash.com/336x200/?book
    //https://source.unsplash.com/336x200/?nature,water
    //https://source.unsplash.com/336x200/?desert
    //https://source.unsplash.com/336x200/?flowers
    //https://source.unsplash.com/336x200/?flowers,rose
    @PostMapping("/book-form")
    @Transactional
    public String saveBook(@Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "admin/book-form";
        }
        Category category=categoryDao.findById(book.getCategory().getId()).get()    ;
        Author author=authorDao.findById(book.getAuthor().getId()).get();
        category.addBook(book);
        author.addAuthor(book);
        bookDao.save(book);

        return "redirect:/admin/book/all";
    }

    @GetMapping("/book/all")
    public String listAllBook(Model model){
        model.addAttribute("books",bookDao.findAll());
        return "admin/book-list";
    }



}
