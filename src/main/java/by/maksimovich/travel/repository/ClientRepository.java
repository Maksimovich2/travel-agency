package by.maksimovich.travel.repository;

import by.maksimovich.travel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 11:46
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByLastName(String lastName);

    @Modifying
    @Query("update Client c set c = :c where c.id = :id")
    void update(@Param("id") Long id, @Param("c") Client client);
}
