package com.example.librarySystem.repository;

import com.example.librarySystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Integer> {
}
