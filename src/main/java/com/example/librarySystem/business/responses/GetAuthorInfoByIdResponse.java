package com.example.librarySystem.business.responses;

import lombok.Data;

import java.util.List;

@Data
public class GetAuthorInfoByIdResponse {
    private int id;
    private String name;
    private List<GetAllBookResponse> books;
}
