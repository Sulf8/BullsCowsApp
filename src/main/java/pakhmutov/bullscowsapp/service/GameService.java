package pakhmutov.bullscowsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.gameLogic.NumberGenerator;
import pakhmutov.bullscowsapp.entity.Game;
import pakhmutov.bullscowsapp.gameLogic.Checker;
import pakhmutov.bullscowsapp.repositories.GameRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService{
    private final GameRepository gameRepository;
    private final Checker checker;
    private final NumberGenerator numberGenerator;

    @Autowired
    public GameService(GameRepository gameRepository, Checker checker, NumberGenerator numberGenerator) {
        this.gameRepository = gameRepository;
        this.checker = checker;
        this.numberGenerator = numberGenerator;
    }

    /**
     * {@Link pakhmutov.bullscowsapp.gameLogic.Checker#check(List<Integer>, List<Integer>) check}
     */
    public List<Integer> generate(int i) {
        return numberGenerator.generateNumber(i);
    }

    /**
     * {@Link pakhmutov.bullscowsapp.gameLogic.NumberGenerator#generateNumber(int) generateNumber}
     */
    public String check(List<Integer> userNumber, List<Integer> sample) {
        String result = "";
        try {
            result = checker.check(userNumber, sample);
        } catch (IllegalArgumentException|NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String check(String userNumberStr, List<Integer> sample) {
        String result = "";
        try {
            result = checker.check(userNumberStr, sample);
        } catch (IllegalArgumentException|NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    //@Query(value = "INSERT INTO Game VALUES (:username, :userNumber, :animalCode)", nativeQuery = true)
    public void addTry(String username, List<Integer> userNumber, String animalCode) {
        gameRepository.save(new Game(username, userNumber, animalCode));
    }
}
