package com.example.librarySystem.controller;

import com.example.librarySystem.business.concretes.UserService;
import com.example.librarySystem.core.annotation.Log;
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
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/login")
    public Result<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/create")
    public Result<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return userService.create(createUserRequest);
    }
}
