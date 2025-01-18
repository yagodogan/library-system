package com.example.librarySystem.business.abstracts;


import com.example.librarySystem.business.requests.CreateUserRequest;
import com.example.librarySystem.business.responses.GetAllUsers;

import java.util.List;

public interface IUserService {
    void CreateUser(CreateUserRequest user);
    List<GetAllUsers> getAllUsers();
}
