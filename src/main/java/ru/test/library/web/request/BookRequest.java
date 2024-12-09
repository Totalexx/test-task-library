package ru.test.library.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRequest {
    private String title;
    private String author;
    private Long isbn;
}
