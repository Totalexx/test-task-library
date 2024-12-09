package ru.test.library.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.test.library.mapper.ClientMapper;
import ru.test.library.model.Client;
import ru.test.library.service.ClientService;
import ru.test.library.web.dto.ClientDto;
import ru.test.library.web.dto.PagedClientListDto;
import ru.test.library.web.request.AddClientRequest;
import ru.test.library.web.request.UpdateClientRequest;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping
    public String getClients(@PageableDefault Pageable pageable, Model model) {
        Page<Client> clientPage = clientService.getPaginatedClients(pageable.getPageNumber());
        PagedClientListDto clients = clientMapper.mapToPagedClientListDto(clientPage);
        model.addAttribute("clients", clients);

        return "client/client-list";
    }

    @PostMapping("add")
    public String addClient(@ModelAttribute @Valid AddClientRequest request) {
        Client client = clientMapper.mapToClient(request);
        clientService.addClient(client);

        return "redirect:/client/";
    }

    @GetMapping("{id}")
    public String getUpdateClientPage(@PathVariable UUID id, Model model) {
        Client client = clientService.getClient(id);
        ClientDto clientDto = clientMapper.mapToClientDto(client);

        model.addAttribute("client", clientDto);
        return "client/edit-client";
    }

    @PostMapping("update/")
    public String updateClient(@ModelAttribute @Valid UpdateClientRequest request) {
        Client client = clientMapper.mapToClient(request);
        clientService.updateClient(client);

        return "redirect:/client/";
    }
}
