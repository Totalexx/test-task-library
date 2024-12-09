package ru.test.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.library.exception.ServiceException;
import ru.test.library.model.Book;
import ru.test.library.model.Client;
import ru.test.library.model.Rent;
import ru.test.library.repository.RentRepository;
import ru.test.library.service.BookService;
import ru.test.library.service.ClientService;
import ru.test.library.service.RentService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final BookService bookService;
    private final ClientService clientService;
    private final RentRepository rentRepository;

    @Override
    public void rent(Client client, Book book) {
        if (client.getId() == null || !clientService.isClientPresent(client.getId()))
            throw new ServiceException("Client is not present");

        if (book.getId() == null || !bookService.isBookPresent(book.getId()))
            throw new ServiceException("Book is not present");

        Rent rent = new Rent(book, client, LocalDate.now());
        rentRepository.save(rent);
    }

    @Override
    public List<Rent> getRents() {
        return rentRepository.findAll();
    }

}
