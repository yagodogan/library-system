package com.example.librarySystem.repository;

import com.example.librarySystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {
    boolean existsByName(String name);

}
