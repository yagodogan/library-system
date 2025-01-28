package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.abstracts.IUserService;
import com.example.librarySystem.dto.request.CreateUserRequest;
import com.example.librarySystem.dto.response.GetAllUsersResponse;
import com.example.librarySystem.dto.response.GetUserByIdResponse;
import com.example.librarySystem.core.mapper.IModelMapperService;
import com.example.librarySystem.repository.IUserRepository;
import com.example.librarySystem.entity.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IModelMapperService modelMapperService;
    private final IUserRepository userRepository;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        Users user = this.modelMapperService.forRequest().map(createUserRequest, Users.class);
        this.userRepository.save(user);
    }

    @Override
    public List<GetAllUsersResponse> getAllUsers() {
        List<Users> users = this.userRepository.findAll();
        List<GetAllUsersResponse> response = users.stream()
                .map(user -> this.modelMapperService.forResponse().
                        map(user, GetAllUsersResponse.class))
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public GetUserByIdResponse getUserById(int id) {
        Users user = this.userRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(user, GetUserByIdResponse.class);
    }
}
