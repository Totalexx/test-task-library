package ru.test.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.test.library.exception.ServiceException;
import ru.test.library.model.Client;
import ru.test.library.repository.ClientRepository;
import ru.test.library.service.ClientService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Value("${spring.data.web.pageable.default-page-size}")
    private int pageSize;

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findById(client.getId());
        if (!clientOptional.isPresent())
            throw new ServiceException("Client not found");

        clientRepository.save(client);
    }

    @Override
    public Page<Client> getPaginatedClients(int page) {
        return clientRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Client> getPaginatedFilteredClients(Client client, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        return clientRepository.findAll(Example.of(client, matcher), pageable);
    }

    @Override
    public Client getClient(UUID id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ServiceException("Client not found"));
    }

    @Override
    public boolean isClientPresent(UUID id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.isPresent();
    }
}
