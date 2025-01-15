package com.example.librarySystem.dataAccess.abstracts;

import com.example.librarySystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {
    boolean existsByName(String name);

}
