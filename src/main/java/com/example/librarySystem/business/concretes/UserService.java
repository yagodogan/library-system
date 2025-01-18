package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.abstracts.IUserService;
import com.example.librarySystem.business.requests.CreateUserRequest;
import com.example.librarySystem.business.responses.GetAllUsers;
import com.example.librarySystem.core.utilities.mappers.IModelMapperService;
import com.example.librarySystem.dataAccess.abstracts.IUserRepository;
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
    public void CreateUser(CreateUserRequest createUserRequest) {
        Users user = this.modelMapperService.forRequest().map(createUserRequest, Users.class);
        this.userRepository.save(user);
    }

    @Override
    public List<GetAllUsers> getAllUsers() {
        List<Users> users = this.userRepository.findAll();
        List<GetAllUsers> response = users.stream()
                .map(user -> this.modelMapperService.forResponse().
                        map(user, GetAllUsers.class))
                .collect(Collectors.toList());

        return response;
    }
}
