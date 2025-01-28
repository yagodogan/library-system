package com.example.librarySystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class AddBookRequest {

    @NotBlank
    @NotNull
    @Size(min = 1, max = 30)
    private String title;

    private int authorId;

    private int categoryId;
}
