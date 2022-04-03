package pakhmutov.bullscowsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pakhmutov.bullscowsapp.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
