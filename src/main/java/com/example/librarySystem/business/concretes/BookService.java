package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.abstracts.IBookService;
import com.example.librarySystem.dto.request.AddBookRequest;
import com.example.librarySystem.dto.request.UpdateBookRequest;
import com.example.librarySystem.dto.response.GetAllBookResponse;
import com.example.librarySystem.dto.response.GetBookByIdResponse;
import com.example.librarySystem.core.annotation.Log;
import com.example.librarySystem.core.mapper.IModelMapperService;
import com.example.librarySystem.repository.IBookRepository;
import com.example.librarySystem.entity.Book;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final IBookRepository bookRepository;
    private final IModelMapperService modelMapperService;

    @Override
    public List<GetAllBookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        List<GetAllBookResponse> response = books.stream()
                .map(book -> this.modelMapperService.forResponse()
                        .map(book, GetAllBookResponse.class))
                .collect(Collectors.toList());

        return response;
    }

    @Log
    @Override
    public GetBookByIdResponse getBookById(int id) {
        Book book = this.bookRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(book, GetBookByIdResponse.class);
    }

    @Override
    public void addBook(AddBookRequest request) {
        Book book = this.modelMapperService.forRequest().map(request, Book.class);
        this.bookRepository.save(book);
    }

    @Override
    @Transactional
    public void updateBook(int id, UpdateBookRequest updateBookRequest) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        this.modelMapperService.forRequest().map(updateBookRequest, book);
        this.bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        this.bookRepository.deleteById(id);
    }
}
