package com.example.librarySystem.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    @NotBlank
    @NotNull
    @Size(min = 1, max = 30)
    private String title;
    private int authorId;
    private int categoryId;
}
