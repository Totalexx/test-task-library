package ru.test.library.web.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.library.mapper.RentMapper;
import ru.test.library.model.Rent;
import ru.test.library.service.RentService;
import ru.test.library.web.response.RentResponseList;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class RentRestController {

    private final RentService rentService;
    private final RentMapper rentMapper;

    @GetMapping("rent/get/all")
    public ResponseEntity<RentResponseList> getAllRents() {
        List<Rent> rents = rentService.getRents();
        RentResponseList rentsResponse = rentMapper.mapToResponseList(rents);

        return ResponseEntity.ok(rentsResponse);
    }
}
