package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        if (book.getId() == null) {
            System.out.println("ERROR. No existe el libro");
            return ResponseEntity.badRequest().build();
        }
        if (bookRepository.existsById(book.getId())) {
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/books")
    public ResponseEntity<Book> deleteAll() {
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
