package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.dto.request.AddBookRequest;
import com.example.librarySystem.dto.request.UpdateBookRequest;
import com.example.librarySystem.dto.response.GetAllBookResponse;
import com.example.librarySystem.dto.response.GetBookByIdResponse;

import java.util.List;

public interface IBookService {
    List<GetAllBookResponse> getAllBooks();
    GetBookByIdResponse getBookById(int id);
    void addBook(AddBookRequest request);
    void updateBook(int id,UpdateBookRequest updateBookRequest);
    void deleteBook(int id);
}
