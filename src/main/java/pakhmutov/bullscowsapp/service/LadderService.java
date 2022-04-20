package pakhmutov.bullscowsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.entity.Ladder;
import pakhmutov.bullscowsapp.entity.LadderAVG;
import pakhmutov.bullscowsapp.repositories.LadderRepository;

import java.util.List;

/**
 * взаимодействие с рейтинговой таблицей
 */
@Service
@RequiredArgsConstructor
public class LadderService {
    private final LadderRepository ladderRepository;

    public List<LadderAVG> showLadderWithAVG(){
        return ladderRepository.findAllWithAVG();
    }

    /**
     * @param username текущий пользователь
     * @param count количество попыток текущего пользователя до угадывания
     */
    //@Query (value = "INSERT INTO Ladder VALUES (:username, :count))", nativeQuery = true)
    public void addInLadder(String username, int count) {
        ladderRepository.save(new Ladder(username, count));
    }
}
