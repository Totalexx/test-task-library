package ru.test.library.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PagedClientListDto {
    private List<ClientDto> clients;
    private PaginationDto pagination;
}
