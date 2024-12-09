package ru.test.library.service;

import ru.test.library.model.Book;
import ru.test.library.model.Client;
import ru.test.library.model.Rent;

import java.util.List;

public interface RentService {
    void rent(Client client, Book book);
    List<Rent> getRents();
}
