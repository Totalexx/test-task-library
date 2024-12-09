package ru.test.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.test.library.exception.ServiceException;
import ru.test.library.model.Book;
import ru.test.library.repository.BookRepository;
import ru.test.library.service.BookService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Value("${spring.data.web.pageable.default-page-size}")
    private int pageSize;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getId());
        if (!bookOptional.isPresent())
            throw new ServiceException("Book not found");

        bookRepository.save(book);
    }

    @Override
    public Page<Book> getPaginatedBooks(int page) {
        return bookRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Book> getPaginatedFilteredBooks(Book bookReference, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        return bookRepository.findAll(Example.of(bookReference, matcher), pageable);
    }

    @Override
    public Book getBook(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Book not found"));
    }

    @Override
    public boolean isBookPresent(UUID id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.isPresent();
    }
}
