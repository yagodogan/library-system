package com.example.librarySystem.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddCategoryRequest {
    @NotBlank
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
}
