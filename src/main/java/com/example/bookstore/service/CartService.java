package com.example.bookstore.service;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.ds.BookDto;
import com.example.bookstore.ds.CartBean;
import com.example.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    private CartBean cartBean;
    @Autowired
    private BookDao bookDao;

    public void addToCart(int id){
        cartBean.addToCart(toDto(bookDao.findById(id).get()));
    }

    public Set<BookDto> listCart(){
        return cartBean.listAllCart();
    }

public void clearCart(){
cartBean.clearCart();
}

    public void removeFromCart(BookDto bookDto){
        cartBean.removeBook(bookDto);
    }

    public BookDto toDto(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getYearPublished(),
                book.getPublisher(),
                book.getPrice(),
                book.getQuantity(),
                book.getImageUrl(),
                book.getGenre(),
                book.getDescription(),
                book.getCategory(),
                book.getAuthor()
        );
    }

}
