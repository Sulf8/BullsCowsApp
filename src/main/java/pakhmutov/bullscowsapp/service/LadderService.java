package pakhmutov.bullscowsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.entity.Ladder;
import pakhmutov.bullscowsapp.repositories.LadderRepository;
import java.util.List;

/**
 * взаимодействие с рейтинговой таблицей
 */
@Service
@RequiredArgsConstructor
public class LadderService {
    private final LadderRepository ladderRepository;

    /**
     * Метод, показывающий таблицу Ladder, записи будут отражать количество попыток пользователей до угадывания числа
     * @return все записи таблицы Ladder
     */
    //@Query (value = "SELECT * INTO Ladder", nativeQuery = true)
    public List<Ladder> showLadder() {
        return ladderRepository.findAll();
    }

    /**
     * Метод, показывающий таблицу с средним количеством попыток до угадывания для каждого пользователя
     * @return все записи таблицы, где в одной колонке будут пользователи, во второй число,
     * являющиеся средним по этим пользоателям из таблицы Ladder
     */
    public List<LadderRepository.LadderAVG> showLadderWithAVG(){
        return ladderRepository.findAllWithAVG();
    }

    /**
     * Метод, добавляющий в таблицу Ladder запись с именем текущего пользователя и количеством попыток до угадывания
     * @param username текущий пользователь
     * @param count количество попыток текущего пользователя до угадывания
     */
    //@Query (value = "INSERT INTO Ladder VALUES (:username, :count))", nativeQuery = true)
    public void addInLadder(String username, int count) {
        ladderRepository.save(new Ladder(username, count));
    }
}
