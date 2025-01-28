package com.example.librarySystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllBookResponse {

    private int id;

    private String title;

    private String authorName;

    private String categoryName;
}
