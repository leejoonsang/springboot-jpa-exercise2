package com.jpa.exercise.controller;

import com.jpa.exercise.domain.Book;
import com.jpa.exercise.domain.dto.BookResponse;
import com.jpa.exercise.repository.BookRepository;
import com.jpa.exercise.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

//    public BookController(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

//    @GetMapping("")
//    public ResponseEntity<List<Book>> list() {
//        List<Book> bookList = bookRepository.findAll();
//        return ResponseEntity.ok().body(bookList);
//    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable) {
        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Book> get(@PathVariable Long id) {
//        Book book = bookRepository.findById(id).get();
//        return ResponseEntity.ok().body(book);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id) {
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok().body(book);
    }
}
