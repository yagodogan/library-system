package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.dto.request.AddAuthorRequest;
import com.example.librarySystem.dto.request.UpdateAuthorRequest;
import com.example.librarySystem.dto.response.GetAuthorInfoByIdResponse;
import com.example.librarySystem.dto.response.GetAllAuthorResponse;

import java.util.List;

public interface IAuthorService {
    List<GetAllAuthorResponse> getAllAuthors();
    GetAuthorInfoByIdResponse getAuthorInfoById(int id);
    void addAuthor(AddAuthorRequest addAuthorRequest);
    void updateAuthor(UpdateAuthorRequest updateAuthorRequest);
    void deleteAuthor(int id);
}
