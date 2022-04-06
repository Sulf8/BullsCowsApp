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
     * @see /gameLogic/NumberGenerator.java
     */
    public List<Integer> generate(int i) {
        return numberGenerator.generateNumber(i);
    }

    /**
     * @see /gameLogic/Checker.java
     */
    public String check(List<Integer> userNumber, List<Integer> sample) {
        return checker.check(userNumber, sample);
    }

    //@Query(value = "INSERT INTO Game VALUES (:username, :userNumber, :animalCode)", nativeQuery = true)
    public void add(String username, List<Integer> userNumber, String animalCode) {
        gameRepository.save(new Game(username, userNumber, animalCode));
    }


    public boolean isVictory() {
        String animalCode = null;
        return animalCode.equals("4Б0К");
    }


}
