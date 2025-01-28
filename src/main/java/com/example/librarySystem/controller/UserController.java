package com.example.librarySystem.controller;

import com.example.librarySystem.business.concretes.UserService;
import com.example.librarySystem.dto.request.CreateUserRequest;
import com.example.librarySystem.dto.response.GetAllUsersResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("getAllUsers")
    public List<GetAllUsersResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("createUser")
    public void createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        this.userService.createUser(createUserRequest);
    }
}
