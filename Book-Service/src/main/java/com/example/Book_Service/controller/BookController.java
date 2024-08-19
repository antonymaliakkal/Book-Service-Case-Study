package com.example.Book_Service.controller;

import com.example.Book_Service.domain.Book;
import com.example.Book_Service.dto.BookDto;
import com.example.Book_Service.service.BookServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookDto dto){
            Book book = bookService.createBook(dto);
            return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookByID(id));
    }

    @GetMapping
    public  ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody BookDto dto , @PathVariable Long id){
        return ResponseEntity.ok(bookService.updateBook(dto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        String s = bookService.deleteBook(id);
        return ResponseEntity.ok("Deleted Book");
    }

    @PutMapping("/stock/{id}/{quant}")
    public ResponseEntity<String> reduceStock(@PathVariable Long id , @PathVariable int quant){
        return ResponseEntity.ok(bookService.reduceStock(id,quant));
    }

}
