package com.example.librarySystem.business.rules;

import com.example.librarySystem.core.utilities.exeptions.BusinessException;
import com.example.librarySystem.dataAccess.abstracts.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryBusinessRules {
    private ICategoryRepository categoryRepository;

    public void checkIfAuthorNameExists(String name) {
        if(this.categoryRepository.existsByName(name)) {
            throw new BusinessException("Category name already exists");
        }
    }
}
