package com.example.librarySystem.repositories;

import com.example.librarySystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
