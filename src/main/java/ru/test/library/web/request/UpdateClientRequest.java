package ru.test.library.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class UpdateClientRequest {

    @NotNull(message = "ID не должно быть пустым")
    private UUID id;

    @NotBlank(message = "Имя не должно быть пустым")
    private String name;

    @NotBlank(message = "Фамилия не должна быть пустой")
    private String middleName;

    @NotBlank(message = "Отчество не должно быть пустым")
    private String lastName;

    @NotNull(message = "Дата рождения не должна быть пустой")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
}