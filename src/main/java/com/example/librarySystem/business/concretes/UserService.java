package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.abstracts.IUserService;
import com.example.librarySystem.business.requests.CreateUserRequest;
import com.example.librarySystem.business.responses.GetAllUsersResponse;
import com.example.librarySystem.business.responses.GetUserByIdResponse;
import com.example.librarySystem.core.utilities.mappers.IModelMapperService;
import com.example.librarySystem.repositories.IUserRepository;
import com.example.librarySystem.entities.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private IModelMapperService modelMapperService;
    private IUserRepository userRepository;

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
