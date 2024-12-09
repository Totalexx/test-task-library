package ru.test.library.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.test.library.model.Client;

import java.util.UUID;

public interface ClientService {
    void addClient(Client client);
    void updateClient(Client client);

    Page<Client> getPaginatedClients(int page);
    Page<Client> getPaginatedFilteredClients(Client client, Pageable pageable);

    Client getClient(UUID id);

    boolean isClientPresent(UUID id);
}
