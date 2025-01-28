package com.example.librarySystem.business.concretes;

import com.example.librarySystem.dto.request.AddAuthorRequest;
import com.example.librarySystem.dto.request.UpdateAuthorRequest;
import com.example.librarySystem.dto.response.GetAuthorInfoByIdResponse;
import com.example.librarySystem.dto.response.GetAllAuthorResponse;
import com.example.librarySystem.business.abstracts.IAuthorService;
import com.example.librarySystem.business.rules.AuthtorBusinessRules;
import com.example.librarySystem.core.mapper.IModelMapperService;
import com.example.librarySystem.repository.IAuthorRepository;
import com.example.librarySystem.entity.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;
    private final IModelMapperService modelMapperService;
    private final AuthtorBusinessRules authtorBusinessRules;


    @Override
    public List<GetAllAuthorResponse> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();

        List<GetAllAuthorResponse> responses = authors.stream()
                .map(author -> this.modelMapperService.forResponse()
                        .map(author, GetAllAuthorResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetAuthorInfoByIdResponse getAuthorInfoById(int id) {
        Author author = this.authorRepository.findById(id).orElse(null);

        GetAuthorInfoByIdResponse response = this.modelMapperService.forResponse().map(author, GetAuthorInfoByIdResponse.class);
        return response;

    }

    @Override
    public void addAuthor(AddAuthorRequest addAuthorRequest) {
        this.authtorBusinessRules.checkIfAuthorNameExists(addAuthorRequest.getName());

        Author author = this.modelMapperService.forRequest().map(addAuthorRequest, Author.class);
        this.authorRepository.save(author);
    }

    @Override
    public void updateAuthor(UpdateAuthorRequest updateAuthorRequest) {
        Author author = this.modelMapperService.forRequest().map(updateAuthorRequest, Author.class);
        this.authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        this.authorRepository.deleteById(id);
    }

}
