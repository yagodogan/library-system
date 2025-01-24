package com.example.librarySystem.business.responses;

import lombok.Data;

@Data
public class GetUserByIdResponse {
    private int userId;
    private String userName;
}
