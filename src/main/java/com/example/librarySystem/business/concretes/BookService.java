package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.requests.AddBookRequest;
import com.example.librarySystem.business.requests.UpdateBookRequest;
import com.example.librarySystem.business.responses.GetAllBookResponse;
import com.example.librarySystem.business.abstracts.IBookService;
import com.example.librarySystem.core.utilities.mappers.IModelMapperService;
import com.example.librarySystem.dataAccess.abstracts.IBookRepository;
import com.example.librarySystem.entities.Book;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final LocalContainerEntityManagerFactoryBean entityManagerFactory;
    private IBookRepository bookRepository;
    private IModelMapperService modelMapperService;


    @Override
    public List<GetAllBookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        List<GetAllBookResponse> response = books.stream()
                .map(book -> this.modelMapperService.forResponse()
                        .map(book, GetAllBookResponse.class))
                .collect(Collectors.toList());

        return response;
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
