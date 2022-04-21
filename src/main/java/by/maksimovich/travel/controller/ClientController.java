package by.maksimovich.travel.controller;

import by.maksimovich.travel.controller.convertor.ClientConvertor;
import by.maksimovich.travel.controller.dto.client.ClientDto;
import by.maksimovich.travel.controller.dto.client.ClientDtoSaveRequest;
import by.maksimovich.travel.entity.Client;
import by.maksimovich.travel.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 16:53
 */
@Controller
@Validated
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final ClientService clientService;
    private final ClientConvertor convertor;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody ClientDtoSaveRequest clientDtoSaveRequest) {
        clientService.save(convertor
                .convertToEntity(clientDtoSaveRequest));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(convertor
                .convertToDto(clientService.findById(id)));
    }

    @GetMapping("/clients")
    public String findAll(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
