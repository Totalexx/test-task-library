package ru.test.library.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PagedBookListDto {
    private List<BookDto> books;
    private PaginationDto pagination;
}
