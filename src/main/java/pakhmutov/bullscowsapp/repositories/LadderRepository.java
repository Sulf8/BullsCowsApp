package pakhmutov.bullscowsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pakhmutov.bullscowsapp.entity.Ladder;

@Repository
public interface LadderRepository extends JpaRepository<Ladder, String> {
}
