package pakhmutov.bullscowsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pakhmutov.bullscowsapp.entity.Ladder;
import pakhmutov.bullscowsapp.entity.LadderAVG;
import pakhmutov.bullscowsapp.entity.LadderStatistic;

import java.util.List;

@Repository
public interface LadderRepository extends JpaRepository<Ladder, Integer> {

    @Query(value = "SELECT username, AVG(count_Of_Trys) FROM Ladder GROUP BY username ORDER BY AVG(count_Of_Trys) ASC",
            nativeQuery = true)
    List<LadderStatistic> findAllWithAVG();
}
