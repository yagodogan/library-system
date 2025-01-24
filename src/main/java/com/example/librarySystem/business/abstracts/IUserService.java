package com.example.librarySystem.business.abstracts;


import com.example.librarySystem.business.requests.CreateUserRequest;
import com.example.librarySystem.business.responses.GetAllUsersResponse;
import com.example.librarySystem.business.responses.GetUserByIdResponse;

import java.util.List;

public interface IUserService {
    void createUser(CreateUserRequest user);
    List<GetAllUsersResponse> getAllUsers();
    GetUserByIdResponse getUserById(int id);
}
