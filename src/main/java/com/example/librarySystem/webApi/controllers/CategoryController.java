package com.example.librarySystem.webApi.controllers;

import com.example.librarySystem.business.concretes.CategoryService;
import com.example.librarySystem.business.requests.AddCategoryRequest;
import com.example.librarySystem.business.requests.UpdateCategoryRequest;
import com.example.librarySystem.business.responses.GetAllCategoryResponse;
import com.example.librarySystem.business.responses.GetCategoryByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("getCategoryById={id}")
    public GetCategoryByIdResponse getCategory(@PathVariable int id) {
        return categoryService.getCategoryInfoById(id);
    }

    @GetMapping("getAllCategories")
    public List<GetAllCategoryResponse> getAllCategories() {
        return this.categoryService.getAllCategory();
    }

    @PostMapping("addCategory")
    public void addCategory(@Valid @RequestBody AddCategoryRequest request) {
        categoryService.addCategory(request);
    }

    @PutMapping("updateCategoryById={id}")
    public void updateCategoryById(@PathVariable int id,@Valid @RequestBody UpdateCategoryRequest request) {
        this.categoryService.updateCategory(id, request);
    }

    @DeleteMapping("deleteCategoryById={id}")
    public void deleteCategory(@PathVariable int id) {
        this.categoryService.deleteCategory(id);
    }

}
