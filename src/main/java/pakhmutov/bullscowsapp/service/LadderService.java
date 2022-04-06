package pakhmutov.bullscowsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LadderService {
    private final LadderRepository ladderRepository;

    @Autowired
    public LadderService(LadderRepository ladderRepository) {
        this.ladderRepository = ladderRepository;
    }

    /**
     * @return список релуьтатов пользователей, отсортированный на наименьшему количеству попыток
     */
    //@Query(value = "SELECT * FROM Ladder l ORDER BY l.countOfTrys DESC ", nativeQuery = true)
    public List<Ladder> showLadder(){
       return ladderRepository.findAll().stream()
               .sorted(Comparator.comparingInt(Ladder::getAVGcountOfTrys).reversed())
               .collect(Collectors.toList());
    }
}
