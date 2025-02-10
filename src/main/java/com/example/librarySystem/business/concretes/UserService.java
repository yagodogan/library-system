package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.abstracts.IUserService;
import com.example.librarySystem.business.rules.UserBussinesRules;
import com.example.librarySystem.core.result.Result;
import com.example.librarySystem.dto.request.CreateUserRequest;
import com.example.librarySystem.dto.request.UserLoginRequest;
import com.example.librarySystem.dto.response.CreateUserResponse;
import com.example.librarySystem.dto.response.GetAllUsersResponse;
import com.example.librarySystem.dto.response.GetUserByIdResponse;
import com.example.librarySystem.core.mapper.IModelMapperService;
import com.example.librarySystem.dto.response.UserLoginResponse;
import com.example.librarySystem.repository.IUserRepository;
import com.example.librarySystem.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IModelMapperService modelMapperService;
    private final IUserRepository userRepository;
    private final UserBussinesRules userBussinesRules;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public Result<CreateUserResponse> create(CreateUserRequest createUserRequest) {

        Result<User> result = userBussinesRules.checkIfUserExists(createUserRequest.getUsername());
        if(result.isSuccess()) {
            return new Result<>(false, result.getMessage());
        }
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);

        return new Result<>(true, result.getMessage());
    }

    @Override
    public Result<UserLoginResponse> login(UserLoginRequest request) {
        Result<User> result = userBussinesRules.checkIfUserExistsAndComparePassword(request.getUsername(), request.getPassword());
        if(result.isSuccess()) {
            return new Result<>(true, new UserLoginResponse(jwtService.generateToken(result.getData())));
        }
        return new Result<>(false, result.getMessage());
    }


    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<GetAllUsersResponse> response = users.stream()
                .map(user -> this.modelMapperService.forResponse().
                        map(user, GetAllUsersResponse.class))
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public GetUserByIdResponse getUserById(int id) {
        User user = this.userRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(user, GetUserByIdResponse.class);
    }
}
