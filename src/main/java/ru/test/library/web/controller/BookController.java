package ru.test.library.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.test.library.mapper.BookMapper;
import ru.test.library.model.Book;
import ru.test.library.service.BookService;
import ru.test.library.web.dto.BookDto;
import ru.test.library.web.dto.PagedBookListDto;
import ru.test.library.web.request.AddBookRequest;
import ru.test.library.web.request.UpdateBookRequest;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public String getBooks(@PageableDefault Pageable pageable, Model model) {
        Page<Book> bookPage = bookService.getPaginatedBooks(pageable.getPageNumber());
        PagedBookListDto books = bookMapper.mapToPagedBookList(bookPage);
        model.addAttribute("books", books);

        return "book/book-list";
    }

    @PostMapping("add")
    public String addBook(@ModelAttribute @Valid AddBookRequest request) {
        Book book = bookMapper.mapToBook(request);
        bookService.addBook(book);

        return "redirect:/book/";
    }

    @GetMapping("{id}")
    public String getUpdateBookPage(@PathVariable UUID id, Model model) {
        Book book = bookService.getBook(id);
        BookDto bookDto = bookMapper.mapToBookDto(book);

        model.addAttribute("book", bookDto);
        return "book/edit-book";
    }

    @PostMapping("update/")
    public String updateBook(@ModelAttribute @Valid UpdateBookRequest request) {
        Book book = bookMapper.mapToBook(request);
        bookService.updateBook(book);

        return "redirect:/book/";
    }
}
