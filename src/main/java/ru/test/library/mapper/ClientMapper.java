package ru.test.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import ru.test.library.model.Client;
import ru.test.library.web.dto.ClientDto;
import ru.test.library.web.dto.PagedClientListDto;
import ru.test.library.web.request.AddClientRequest;
import ru.test.library.web.request.ClientRequest;
import ru.test.library.web.request.UpdateClientRequest;

import java.util.List;
import java.util.UUID;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {PageMapper.class}
)
public interface ClientMapper {

    Client mapToClient(AddClientRequest request);
    Client mapToClient(UpdateClientRequest request);
    Client mapToClient(ClientRequest request);

    @Mapping(target = "id", source = "clientId")
    Client mapToClient(UUID clientId);

    ClientDto mapToClientDto(Client client);

    @Mapping(target = "clients", source = "page", qualifiedByName = "clientDto")
    @Mapping(target = "pagination", source = "page")
    PagedClientListDto mapToPagedClientListDto(Page<Client> page);

    @Named("clientDto")
    default List<ClientDto> mapToBookDtoList(Page<Client> clients) {
        return clients.map(this::mapToClientDto).toList();
    }
}
