package by.maksimovich.travel.service.impl;

import by.maksimovich.travel.entity.Client;
import by.maksimovich.travel.exception.NoDataFoundException;
import by.maksimovich.travel.repository.ClientRepository;
import by.maksimovich.travel.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:58
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("client not found by id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, Client client) {
        Client clientToUpdate = clientRepository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("client not found by id: " + id));
        clientToUpdate.setFirstName(client.getFirstName());
        clientToUpdate.setLastName(client.getLastName());
        clientToUpdate.setSex(client.getSex());
        clientToUpdate.setAge(client.getAge());
        clientToUpdate.setEmail(client.getEmail());
        clientRepository.save(clientToUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findByClientLastName(String lastName) {
        return clientRepository.findByLastName(lastName).orElseThrow(() -> new NoDataFoundException("client not found"));
    }
}
