package ru.test.library.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.test.library.exception.ServiceException;
import ru.test.library.mapper.BookMapper;
import ru.test.library.mapper.ClientMapper;
import ru.test.library.model.Book;
import ru.test.library.model.Client;
import ru.test.library.service.BookService;
import ru.test.library.service.ClientService;
import ru.test.library.service.RentService;
import ru.test.library.web.dto.PagedBookListDto;
import ru.test.library.web.dto.PagedClientListDto;
import ru.test.library.web.request.AddRentRequest;
import ru.test.library.web.request.BookRequest;
import ru.test.library.web.request.ClientRequest;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("rent")
@AllArgsConstructor
@SessionAttributes("clientId")
public class RentController {

    private final RentService rentService;
    private final ClientService clientService;
    private final BookService bookService;

    private final BookMapper bookMapper;
    private final ClientMapper clientMapper;

    @GetMapping("choose/client")
    public String getChooseClientPage(ClientRequest request, @PageableDefault Pageable pageable, Model model) {
        Client clientReference = clientMapper.mapToClient(request);
        Page<Client> clients = clientService.getPaginatedFilteredClients(clientReference, pageable);
        PagedClientListDto clientDtos = clientMapper.mapToPagedClientListDto(clients);

        model.addAttribute("clients", clientDtos);
        model.addAttribute("search", request);

        return "rent/choose-client";
    }

    @PostMapping("choose/client")
    public RedirectView chooseClient(@RequestParam UUID clientId, RedirectAttributes attributes) {
        RedirectView view = new RedirectView("/rent/choose/book");
        attributes.addFlashAttribute("clientId", clientId);

        return view;
    }

    @GetMapping("choose/book")
    public String getChooseBookPage(
            BookRequest request,
            @PageableDefault Pageable pageable,
            Model model
    ) {
        if (!model.containsAttribute("clientId"))
            throw new ServiceException("Client is required");

        Book bookReference = bookMapper.mapToBook(request);
        Page<Book> books = bookService.getPaginatedFilteredBooks(bookReference, pageable);
        PagedBookListDto bookDtos = bookMapper.mapToPagedBookList(books);

        model.addAttribute("books", bookDtos);
        model.addAttribute("search", request);

        return "rent/choose-book";
    }

    @PostMapping("choose/book")
    public String chooseBook() {
        return "redirect:/rent/add";
    }

    @PostMapping("add")
    public String addRent(@Valid AddRentRequest request) {
        Client client = clientMapper.mapToClient(request.getClientId());
        Book book = bookMapper.mapToBook(request.getBookId());

        rentService.rent(client, book);
        return "/rent/rent-added";
    }


}
