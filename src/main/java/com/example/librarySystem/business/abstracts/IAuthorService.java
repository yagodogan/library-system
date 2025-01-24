package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.business.requests.AddAuthorRequest;
import com.example.librarySystem.business.requests.UpdateAuthorRequest;
import com.example.librarySystem.business.responses.GetAuthorInfoByIdResponse;
import com.example.librarySystem.business.responses.GetAllAuthorResponse;

import java.util.List;

public interface IAuthorService {
    List<GetAllAuthorResponse> getAllAuthors();
    GetAuthorInfoByIdResponse getAuthorInfoById(int id);
    void addAuthor(AddAuthorRequest addAuthorRequest);
    void updateAuthor(UpdateAuthorRequest updateAuthorRequest);
    void deleteAuthor(int id);
}
