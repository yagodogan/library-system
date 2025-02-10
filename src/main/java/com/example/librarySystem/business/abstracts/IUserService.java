package com.example.librarySystem.business.abstracts;


import com.example.librarySystem.core.result.Result;
import com.example.librarySystem.dto.request.CreateUserRequest;
import com.example.librarySystem.dto.request.UserLoginRequest;
import com.example.librarySystem.dto.response.CreateUserResponse;
import com.example.librarySystem.dto.response.GetAllUsersResponse;
import com.example.librarySystem.dto.response.GetUserByIdResponse;
import com.example.librarySystem.dto.response.UserLoginResponse;

import java.util.List;

public interface IUserService {
    Result<CreateUserResponse> create(CreateUserRequest user);
    Result<UserLoginResponse> login(UserLoginRequest request);
    List<GetAllUsersResponse> getAll();
    GetUserByIdResponse getUserById(int id);
}
