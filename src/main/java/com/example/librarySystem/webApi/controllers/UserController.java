package com.example.librarySystem.webApi.controllers;

import com.example.librarySystem.business.concretes.UserService;
import com.example.librarySystem.business.requests.CreateUserRequest;
import com.example.librarySystem.business.responses.GetAllUsersResponse;
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
