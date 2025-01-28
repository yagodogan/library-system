package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.dto.request.AddCategoryRequest;
import com.example.librarySystem.dto.request.UpdateCategoryRequest;
import com.example.librarySystem.dto.response.GetAllCategoryResponse;
import com.example.librarySystem.dto.response.GetCategoryByIdResponse;

import java.util.List;

public interface ICategoryService {
    GetCategoryByIdResponse getCategoryInfoById(int id);
    List<GetAllCategoryResponse> getAllCategory();
    void addCategory(AddCategoryRequest addCategoryRequest);
    void deleteCategory(int id);
    void updateCategory(int id,UpdateCategoryRequest updateCategoryRequest);
}
