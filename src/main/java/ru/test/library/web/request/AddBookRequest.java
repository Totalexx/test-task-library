package ru.test.library.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class AddBookRequest {

    @NotBlank(message = "Название не должно быть пустым")
    private String title;

    @NotBlank(message = "Имя автора не должно быть пустым")
    private String author;

    @NotNull(message = "ISBN не должно быть пустым")
    @Digits(integer = 13, fraction = 0)
    @Min(9780000000000L)
    private Long isbn;
}
