package ru.test.library;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.test.library.mapper.BookMapper;
import ru.test.library.model.Book;
import ru.test.library.web.dto.BookDto;

@SpringBootTest
@RequiredArgsConstructor
public class BookMapperTests {

    private final BookMapper bookMapper;

    @Test
    public void testMappingBookToBookDto() {
        String title = "Title";
        String author = "Author";
        Long isbn = 1234567890000L;

        Book book = new Book(title, author, isbn);
        BookDto bookDto = bookMapper.mapToBookDto(book);

        Assertions.assertEquals(book.getTitle(), bookDto.getTitle());
        Assertions.assertEquals(book.getAuthor(), bookDto.getAuthor());
        Assertions.assertEquals(book.getIsbn(), bookDto.getIsbn());
    }
}
