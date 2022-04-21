package by.maksimovich.travel.controller.convertor;

import by.maksimovich.travel.controller.dto.client.ClientDto;
import by.maksimovich.travel.controller.dto.client.ClientDtoSaveRequest;
import by.maksimovich.travel.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 18:18
 */
@Component
public class ClientConvertor {
    private final ModelMapper modelMapper;

    public ClientConvertor() {
        this.modelMapper = new ModelMapper();
    }

    public Client convertToEntity(ClientDto clientDto){
        return modelMapper.map(clientDto, Client.class);
    }

    public ClientDto convertToDto (Client client){
        return modelMapper.map(client, ClientDto.class);
    }

    public Client convertToEntity(ClientDtoSaveRequest clientDtoSaveRequest){
        return modelMapper.map(clientDtoSaveRequest, Client.class);
    }
}
