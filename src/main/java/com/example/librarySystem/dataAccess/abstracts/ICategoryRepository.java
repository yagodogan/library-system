package com.example.librarySystem.dataAccess.abstracts;

import com.example.librarySystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);
}
