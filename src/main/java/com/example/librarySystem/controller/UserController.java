package com.example.librarySystem.controller;

import com.example.librarySystem.business.concretes.UserService;
import com.example.librarySystem.core.result.Result;
import com.example.librarySystem.dto.request.CreateUserRequest;
import com.example.librarySystem.dto.request.UserLoginRequest;
import com.example.librarySystem.dto.response.CreateUserResponse;
import com.example.librarySystem.dto.response.GetAllUsersResponse;
import com.example.librarySystem.dto.response.UserLoginResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("user/getAll")
    public List<GetAllUsersResponse> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("user/login")
    public Result<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("user/create")
    public Result<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return userService.create(createUserRequest);
    }
}
