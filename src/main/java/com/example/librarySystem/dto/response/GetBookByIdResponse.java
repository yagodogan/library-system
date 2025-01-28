package com.example.librarySystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBookByIdResponse {

    private int bookId;

    private String bookTitle;

    private int UserId;
}
