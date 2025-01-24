package com.example.librarySystem.business.responses;

import lombok.Data;

@Data
public class GetBookByIdResponse {
    private int bookId;
    private String bookTitle;
    private int UserId;
}
