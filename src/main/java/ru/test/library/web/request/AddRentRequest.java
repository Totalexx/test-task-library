package ru.test.library.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class AddRentRequest {

    @NotNull(message = "Id клиента не может быть пустым")
    private UUID clientId;

    @NotNull(message = "Id книги не может быть пустым")
    private UUID bookId;
}
