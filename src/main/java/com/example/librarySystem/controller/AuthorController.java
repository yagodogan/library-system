package com.example.librarySystem.controller;

import com.example.librarySystem.dto.request.AddAuthorRequest;
import com.example.librarySystem.dto.request.UpdateAuthorRequest;
import com.example.librarySystem.dto.response.GetAuthorInfoByIdResponse;
import com.example.librarySystem.dto.response.GetAllAuthorResponse;
import com.example.librarySystem.business.abstracts.IAuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {

    private IAuthorService authorService;

    @GetMapping("/getAuthorById/{id}")
    public GetAuthorInfoByIdResponse findAuthorById(@PathVariable int id) {
        return authorService.getAuthorInfoById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllAuthorResponse> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("api/auth/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void addAuthor(@Valid @RequestBody AddAuthorRequest addAuthorRequest) {
        this.authorService.addAuthor(addAuthorRequest);
    }

    @PutMapping("api/auth/updateAuthor")
    public void updateAuthor(@Valid @RequestBody UpdateAuthorRequest updateAuthorRequest) {
        this.authorService.updateAuthor(updateAuthorRequest);
    }

    @DeleteMapping("api/auth/deleteAuthor={id}")
    public void deleteAuthor(@PathVariable int id) {
        this.authorService.deleteAuthor(id);
    }
}
