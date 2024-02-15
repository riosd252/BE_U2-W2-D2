package DavidRios.BE_U2W2D2.repositories;

import DavidRios.BE_U2W2D2.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
