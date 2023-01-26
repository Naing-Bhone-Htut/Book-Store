package com.example.bookstore.ds;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class CartBean {

    private Set<BookDto> bookDtoList=new HashSet<>();

    public void addToCart(BookDto bookDto){
        bookDtoList.add(bookDto);
    }

    public Set<BookDto> listAllCart(){
        return this.bookDtoList;
    }

    public void clearCart(){
        this.bookDtoList.clear();
    }

    public void removeBook(BookDto bookDto){
        bookDtoList.remove(bookDto);
    }

    public int cartSize(){
        return bookDtoList.size();
    }

}
