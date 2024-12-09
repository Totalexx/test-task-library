package ru.test.library.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentResponse {
    private String renterName;
    private String renterMiddleName;
    private String renterLastName;
    private String renterBirthdate;

    private String bookTitle;
    private String bookAuthor;
    private Long bookISBN;

    private LocalDate rentDate;
}
