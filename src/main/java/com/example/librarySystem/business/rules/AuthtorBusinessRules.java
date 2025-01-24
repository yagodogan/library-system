package com.example.librarySystem.business.rules;

import com.example.librarySystem.core.utilities.exeptions.BusinessException;
import com.example.librarySystem.repositories.IAuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AuthtorBusinessRules {
    private IAuthorRepository authorRepository;

    public void checkIfAuthorNameExists(String name) {
        if(this.authorRepository.existsByName(name)) {
            throw new BusinessException("Author name already exists");
        }
    }
}
