package ru.test.library.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BookDto {
    private UUID id;
    private String title;
    private String author;
    private Long isbn;
}
