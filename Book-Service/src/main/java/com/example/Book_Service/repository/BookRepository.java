package com.example.Book_Service.repository;

import com.example.Book_Service.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
