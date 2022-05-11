package by.maksimovich.travel.service;

import by.maksimovich.travel.entity.Client;

import java.util.List;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:55
 */
public interface ClientService {
    void save(Client client);

    Client findById(Long id);

    List<Client> findAll();

    void update(Long id, Client client);

    void delete(Long id);

    Client findByClientLastName(String lastName);
}
