package com.example.librarySystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserByIdResponse {

    private int userId;

    private String userName;
}
