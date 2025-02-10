package com.example.librarySystem.business.rules;

import com.example.librarySystem.business.constants.Messages;
import com.example.librarySystem.core.result.Result;
import com.example.librarySystem.entity.User;
import com.example.librarySystem.repository.IUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBussinesRules {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserBussinesRules(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Result<User> checkIfUserExists(String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        return user.map(value-> new Result<>(true, Messages.UserExists, value)).orElseGet(() ->
                new Result<>(false, Messages.UserDoesNotExists));
    }

    public Result<User> checkIfUserExistsAndComparePassword(String username, String password) {
        Optional<User> user = this.userRepository.findByUsername(username);
        if(user.isPresent()) {
            User u = user.get();
            if(passwordEncoder.matches(password, u.getPassword())){
                return new Result<>(true, u);
            }
            return new Result<>(false,Messages.IncorrectPassword);
        }
        return new Result<>(false,Messages.UserDoesNotExists);
    }
}
