package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:46
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByLastName(String lastName);
}
