package DavidRios.BE_U2W2D2.repositories;

import DavidRios.BE_U2W2D2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
