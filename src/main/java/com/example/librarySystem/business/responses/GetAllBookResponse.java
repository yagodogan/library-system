package com.example.librarySystem.business.responses;

import lombok.Data;

@Data
public class GetAllBookResponse {
    private int id;
    private String title;
    private String authorName;
    private String categoryName;
}
