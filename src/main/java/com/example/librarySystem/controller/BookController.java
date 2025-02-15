package com.example.librarySystem.controller;


import com.example.librarySystem.business.concretes.BookService;
import com.example.librarySystem.core.annotation.Log;
import com.example.librarySystem.dto.request.AddBookRequest;
import com.example.librarySystem.dto.request.CreateLogRequest;
import com.example.librarySystem.dto.request.UpdateBookRequest;
import com.example.librarySystem.dto.response.GetAllBookResponse;
import com.example.librarySystem.dto.response.GetBookByIdResponse;
import com.example.librarySystem.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @Log
    @GetMapping("api/auth/getAll")
    public List<GetAllBookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Log
    @GetMapping("/getBookById={id}")
    public GetBookByIdResponse getBookById(@PathVariable int id, CreateLogRequest createLogRequest) {
        return this.bookService.getBookById(id);
    }

    @PostMapping("/api/auth/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody() AddBookRequest addBookRequest) {
        this.bookService.addBook(addBookRequest);
    }

    @PutMapping("/api/auth/updateBookById={id}")
    public void updateBookById(@PathVariable int id,@Valid @RequestBody UpdateBookRequest updateBookRequest) {
        this.bookService.updateBook(id,updateBookRequest);
    }

    @DeleteMapping("/api/auth/deleteBookById={id}")
    public void deleteBookById(@PathVariable("id") int id) {
    this.bookService.deleteBook(id);}

}
