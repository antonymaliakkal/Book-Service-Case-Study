package com.example.Book_Service.service;

import com.example.Book_Service.domain.Book;
import com.example.Book_Service.dto.BookDto;

import java.util.List;

public interface BookService {

    public Book createBook(BookDto dto);

    public Book getBookByID(Long id);

    public List<Book> getAllBook();

    public Book updateBook(BookDto dto , Long id);

    public String deleteBook(Long id);

    public String reduceStock(Long id , int quant);

}
