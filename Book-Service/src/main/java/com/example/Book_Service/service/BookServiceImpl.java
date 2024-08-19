package com.example.Book_Service.service;

import com.example.Book_Service.domain.Book;
import com.example.Book_Service.dto.BookDto;
import com.example.Book_Service.exception.BookNotFoundException;
import com.example.Book_Service.mapper.BookMapper;
import com.example.Book_Service.repository.BookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    @Override
    public Book createBook(BookDto dto) {
        Book book = bookMapper.toEntity(dto);
        return bookRepository.save(book);
    }

    @Override
    public Book getBookByID(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        throw new BookNotFoundException("Book Invalid Id");
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(BookDto dto, Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book book1 = book.get();
            bookMapper.updateEntity(book1, dto);
            return book1;
        }
        throw new BookNotFoundException("Book Invalid Id");
    }

    @Override
    public String deleteBook(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
            return "Deleted";
        }
        throw new BookNotFoundException("Book Invalid Id");
    }

    @Override
    public String reduceStock(Long id, int quant) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book book1 = book.get();
            int stock = book1.getBookStock() - quant;
            book1.setBookStock(stock);
            bookRepository.save(book1);
            return "Reduced Stock";
        }
        throw new BookNotFoundException("Book Invalid Id");
    }
}