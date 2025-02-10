package com.example.librarySystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String username;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String password;
}
