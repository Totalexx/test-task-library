package ru.test.library.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaginationDto {
    private int page;
    private int lastPage;
}
