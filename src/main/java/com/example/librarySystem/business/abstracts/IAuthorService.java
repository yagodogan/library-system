package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.business.requests.AddAuthorRequest;
import com.example.librarySystem.business.requests.UpdateAuthorRequest;
import com.example.librarySystem.business.responses.GetAuthorInfoById;
import com.example.librarySystem.business.responses.GetAllAuthorResponse;

import java.util.List;

public interface IAuthorService {
    List<GetAllAuthorResponse> getAllAuthors();
    GetAuthorInfoById getAuthorInfoById(int id);
    void addAuthor(AddAuthorRequest addAuthorRequest);
    void updateAuthor(UpdateAuthorRequest updateAuthorRequest);
    void deleteAuthor(int id);
}
