package com.example.librarySystem.business.abstracts;


import com.example.librarySystem.dto.request.CreateUserRequest;
import com.example.librarySystem.dto.response.GetAllUsersResponse;
import com.example.librarySystem.dto.response.GetUserByIdResponse;

import java.util.List;

public interface IUserService {
    void createUser(CreateUserRequest user);
    List<GetAllUsersResponse> getAllUsers();
    GetUserByIdResponse getUserById(int id);
}
