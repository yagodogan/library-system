package com.example.librarySystem.dataAccess.abstracts;

import com.example.librarySystem.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Integer> {
}
