package com.example.librarySystem.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAuthorInfoByIdResponse {

    private int id;

    private String name;

    private List<GetAllBookResponse> books;
}
