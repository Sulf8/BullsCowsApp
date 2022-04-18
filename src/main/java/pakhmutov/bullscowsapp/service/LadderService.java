package pakhmutov.bullscowsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.entity.Ladder;
import pakhmutov.bullscowsapp.repositories.LadderRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * взаимодействие с рейтинговой таблицей
 */
@Service
@RequiredArgsConstructor
public class LadderService {
    private final LadderRepository ladderRepository;

    /**
     * @return список релуьтатов пользователей, отсортированный на наименьшему количеству попыток
     */
    //@Query(value = "SELECT * FROM Ladder l ORDER BY l.countOfTrys DESC ", nativeQuery = true)
    public List<Ladder> showLadder() {
        return ladderRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Ladder::getCountOfTrys))
                .collect(Collectors.toList());
    }

    /**
     * @param username текущий пользователь
     * @param count количество попыток текущего пользователя до угадывания
     */
    //@Query (value = "INSERT INTO Ladder VALUES (:username, :count))", nativeQuery = true)
    public void addInLadder(String username, int count) {
        ladderRepository.save(new Ladder(username, count));
    }

    //TODO написать тут или в репо
    public List<Ladder> getAVGCountOfTrys(List<Ladder> ladderList){
        return null;
    }
}
