package com.example.librarySystem.repositories;

import com.example.librarySystem.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogRepositories extends JpaRepository<Log, Integer> {
}
