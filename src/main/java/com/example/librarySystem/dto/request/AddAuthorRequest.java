package com.example.librarySystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAuthorRequest {

    @NotBlank
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
}
