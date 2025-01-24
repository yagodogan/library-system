package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.business.requests.AddBookRequest;
import com.example.librarySystem.business.requests.CreateLogRequest;
import com.example.librarySystem.business.requests.UpdateBookRequest;
import com.example.librarySystem.business.responses.GetAllBookResponse;
import com.example.librarySystem.business.responses.GetBookByIdResponse;

import java.util.List;

public interface IBookService {
    List<GetAllBookResponse> getAllBooks();
    GetBookByIdResponse getBookById(int id);
    void addBook(AddBookRequest request);
    void updateBook(int id,UpdateBookRequest updateBookRequest);
    void deleteBook(int id);
}
