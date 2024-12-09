package ru.test.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import ru.test.library.web.dto.PaginationDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PageMapper {

    default PaginationDto toPaginationDto(Page<?> page) {
        return new PaginationDto(page.getNumber() + 1, page.getTotalPages());
    }
}
