package pakhmutov.bullscowsapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pakhmutov.bullscowsapp.entity.Ladder;

import java.util.List;

@Repository
public interface LadderRepository extends JpaRepository<Ladder, Integer> {

    @Query(value = "SELECT username, AVG(count_Of_Trys) as avg FROM Ladder GROUP BY username ORDER BY AVG(count_Of_Trys) ASC",
            nativeQuery = true)
    List<LadderAVG> findAllWithAVG();

    /**
     * интерфейс, для таблицы с средним количеством попыток пользователей по угадыванию числа
     */
    interface LadderAVG {
        String getUserName();
        Long getAvg();
    }
}
