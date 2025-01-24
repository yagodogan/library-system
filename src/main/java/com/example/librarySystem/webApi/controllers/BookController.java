package com.example.librarySystem.webApi.controllers;


import com.example.librarySystem.business.concretes.BookService;
import com.example.librarySystem.business.requests.AddBookRequest;
import com.example.librarySystem.business.requests.CreateLogRequest;
import com.example.librarySystem.business.requests.UpdateBookRequest;
import com.example.librarySystem.business.responses.GetAllBookResponse;
import com.example.librarySystem.business.responses.GetBookByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @GetMapping("getAllBooks")
    public List<GetAllBookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("getBookById={id}")
    public GetBookByIdResponse getBookById(@PathVariable int id, CreateLogRequest createLogRequest) {
        return this.bookService.getBookById(id);
    }

    @PostMapping("addBook")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody() AddBookRequest addBookRequest) {
        this.bookService.addBook(addBookRequest);
    }

    @PutMapping("updateBookById={id}")
    public void updateBookById(@PathVariable int id,@Valid @RequestBody UpdateBookRequest updateBookRequest) {
        this.bookService.updateBook(id,updateBookRequest);
    }

    @DeleteMapping("deleteBookById={id}")
    public void deleteBookById(@PathVariable("id") int id) {
    this.bookService.deleteBook(id);}

}
