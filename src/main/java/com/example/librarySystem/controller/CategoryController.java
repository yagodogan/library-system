package com.example.librarySystem.controller;

import com.example.librarySystem.business.concretes.CategoryService;
import com.example.librarySystem.dto.request.AddCategoryRequest;
import com.example.librarySystem.dto.request.UpdateCategoryRequest;
import com.example.librarySystem.dto.response.GetAllCategoryResponse;
import com.example.librarySystem.dto.response.GetCategoryByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/getCategoryById={id}")
    public GetCategoryByIdResponse getCategory(@PathVariable int id) {
        return categoryService.getCategoryInfoById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllCategoryResponse> getAllCategories() {
        return this.categoryService.getAllCategory();
    }

    @PostMapping("/api/auth/add")
    public void addCategory(@Valid @RequestBody AddCategoryRequest request) {
        categoryService.addCategory(request);
    }

    @PutMapping("/api/auth/updateCategoryById={id}")
    public void updateCategoryById(@PathVariable int id,@Valid @RequestBody UpdateCategoryRequest request) {
        this.categoryService.updateCategory(id, request);
    }

    @DeleteMapping("/api/auth/deleteCategoryById={id}")
    public void deleteCategory(@PathVariable int id) {
        this.categoryService.deleteCategory(id);
    }

}
