package ru.test.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import ru.test.library.model.Book;
import ru.test.library.web.dto.BookDto;
import ru.test.library.web.dto.PagedBookListDto;
import ru.test.library.web.request.AddBookRequest;
import ru.test.library.web.request.BookRequest;
import ru.test.library.web.request.UpdateBookRequest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {PageMapper.class}
)
public interface BookMapper {

    Book mapToBook(AddBookRequest request);
    Book mapToBook(UpdateBookRequest request);
    Book mapToBook(BookRequest request);

    @Mapping(target = "id", source = "bookId")
    Book mapToBook(UUID bookId);

    BookDto mapToBookDto(Book book);

    @Mapping(target = "books", source = "page", qualifiedByName = "booksDto")
    @Mapping(target = "pagination", source = "page")
    PagedBookListDto mapToPagedBookList(Page<Book> page);

    @Named("booksDto")
    default List<BookDto> mapToBookDtoList(Page<Book> books) {
        return books.stream().map(this::mapToBookDto).collect(Collectors.toList());
    }
}
