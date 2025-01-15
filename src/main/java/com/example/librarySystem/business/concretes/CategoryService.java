package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.requests.AddCategoryRequest;
import com.example.librarySystem.business.requests.UpdateCategoryRequest;
import com.example.librarySystem.business.responses.GetAllCategoryResponse;
import com.example.librarySystem.business.responses.GetCategoryByIdResponse;
import com.example.librarySystem.business.abstracts.ICategoryService;
import com.example.librarySystem.business.rules.CategoryBusinessRules;
import com.example.librarySystem.core.utilities.mappers.IModelMapperService;
import com.example.librarySystem.dataAccess.abstracts.ICategoryRepository;
import com.example.librarySystem.entities.Category;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

    private IModelMapperService modelMapperService;
    private ICategoryRepository categoryRepository;
    private CategoryBusinessRules categoryBusinessRules;

    @Override
    public GetCategoryByIdResponse getCategoryInfoById(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        GetCategoryByIdResponse response = this.modelMapperService.forResponse().map(category, GetCategoryByIdResponse.class );
        return response;
    }

    @Override
    public List<GetAllCategoryResponse> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponse> responses = categories.stream()
                .map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoryResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public void addCategory(AddCategoryRequest addCategoryRequest) {
        this.categoryBusinessRules.checkIfAuthorNameExists(addCategoryRequest.getName());
        Category category = modelMapperService.forRequest().map(addCategoryRequest, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void updateCategory(int id, UpdateCategoryRequest updateCategoryRequest) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        this.modelMapperService.forRequest().map(updateCategoryRequest, category);
        this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryRepository.deleteById(id);
    }
}
