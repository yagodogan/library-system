package com.example.librarySystem.repository;

import com.example.librarySystem.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogRepositories extends JpaRepository<Log, Integer> {
}
