package com.example.Order_Service.fiegnClient;

import com.example.Order_Service.domain.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "book-service" , url = "http://localhost:8100/book")
public interface BookService {

    @GetMapping("/{id}")
    Book getBookById(@PathVariable Long id);

    @PutMapping("/stock/{id}/{quant}")
    String reduceStock(@PathVariable Long id , @PathVariable int quant);

}
