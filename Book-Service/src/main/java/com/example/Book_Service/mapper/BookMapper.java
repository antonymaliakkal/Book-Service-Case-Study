package com.example.Book_Service.mapper;

import com.example.Book_Service.domain.Book;
import com.example.Book_Service.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookDto dto){
        Book book = new Book();
        book.setBookTitle(dto.bookTitle());
        book.setBookAuthor(dto.bookAuthor());
        book.setBookPrice(dto.bookPrice());
        book.setBookStock(dto.bookStock());
        return book;
    }

    public Book updateEntity(Book book , BookDto dto){
        book.setBookTitle(dto.bookTitle());
        book.setBookAuthor(dto.bookAuthor());
        book.setBookPrice(dto.bookPrice());
        book.setBookStock(dto.bookStock());
        return book;
    }

}
