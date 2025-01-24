package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.requests.AddAuthorRequest;
import com.example.librarySystem.business.requests.UpdateAuthorRequest;
import com.example.librarySystem.business.responses.GetAuthorInfoByIdResponse;
import com.example.librarySystem.business.responses.GetAllAuthorResponse;
import com.example.librarySystem.business.abstracts.IAuthorService;
import com.example.librarySystem.business.rules.AuthtorBusinessRules;
import com.example.librarySystem.core.utilities.mappers.IModelMapperService;
import com.example.librarySystem.repositories.IAuthorRepository;
import com.example.librarySystem.entities.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService implements IAuthorService {

    private IAuthorRepository authorRepository;
    private IModelMapperService modelMapperService;
    private AuthtorBusinessRules authtorBusinessRules;


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
