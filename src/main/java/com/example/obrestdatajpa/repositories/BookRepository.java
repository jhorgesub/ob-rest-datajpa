package com.example.obrestdatajpa.repositories;

import com.example.obrestdatajpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 9.999, LocalDate.of(2020,10,9), true);
    Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 500, 8.995, LocalDate.of(2023,1,18), true);

}
