package com.example.librarySystem.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginResponse {
    private String token;

    public UserLoginResponse(String token) {
        this.token = token;
    }

}
