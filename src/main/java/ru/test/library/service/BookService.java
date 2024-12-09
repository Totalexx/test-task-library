package ru.test.library.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.test.library.model.Book;

import java.util.UUID;

public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);

    Page<Book> getPaginatedBooks(int page);
    Page<Book> getPaginatedFilteredBooks(Book bookReference, Pageable pageable);

    Book getBook(UUID id);

    boolean isBookPresent(UUID id);
}
