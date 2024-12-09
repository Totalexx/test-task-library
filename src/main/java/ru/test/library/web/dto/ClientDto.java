package ru.test.library.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ClientDto {

    private UUID id;
    private String name;
    private String middleName;
    private String lastName;
    private LocalDate birthdate;
}
