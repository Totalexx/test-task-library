package ru.test.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.test.library.model.Rent;
import ru.test.library.web.response.RentResponse;
import ru.test.library.web.response.RentResponseList;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {BookMapper.class, ClientMapper.class}
)
public interface RentMapper {

    @Mapping(target = "bookAuthor", source = "book.author")
    @Mapping(target = "bookTitle", source = "book.title")
    @Mapping(target = "bookISBN", source = "book.isbn")
    @Mapping(target = "renterName", source = "renter.name")
    @Mapping(target = "renterMiddleName", source = "renter.middleName")
    @Mapping(target = "renterLastName", source = "renter.lastName")
    @Mapping(target = "renterBirthdate", source = "renter.birthdate")
    RentResponse mapToResponse(Rent rent);

    default RentResponseList mapToResponseList(List<Rent> rents) {
        return new RentResponseList(rents.stream().map(this::mapToResponse).collect(Collectors.toList()));
    }
}
