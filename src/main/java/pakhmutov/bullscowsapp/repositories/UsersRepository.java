package pakhmutov.bullscowsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pakhmutov.bullscowsapp.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {
}
