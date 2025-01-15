package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.business.requests.AddCategoryRequest;
import com.example.librarySystem.business.requests.UpdateCategoryRequest;
import com.example.librarySystem.business.responses.GetAllCategoryResponse;
import com.example.librarySystem.business.responses.GetCategoryByIdResponse;

import java.util.List;

public interface ICategoryService {
    GetCategoryByIdResponse getCategoryInfoById(int id);
    List<GetAllCategoryResponse> getAllCategory();
    void addCategory(AddCategoryRequest addCategoryRequest);
    void deleteCategory(int id);
    void updateCategory(int id,UpdateCategoryRequest updateCategoryRequest);
}
