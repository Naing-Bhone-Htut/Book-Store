package com.example.bookstore.ds;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Category;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class BookDto {

    private int id;
    private String title;
    private LocalDate yearPublished;
    private String publisher;
    private double price;
    private int quantity;
    private String imageUrl;
    private String genre;
    private String description;
    private Category category;
    private Author author;

    public BookDto(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return id == bookDto.id && title.equals(bookDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
