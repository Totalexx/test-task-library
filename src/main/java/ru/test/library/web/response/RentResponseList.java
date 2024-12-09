package ru.test.library.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RentResponseList {
    private List<RentResponse> rents;
}
