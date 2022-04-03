package pakhmutov.bullscowsapp.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.entity.Game;
import pakhmutov.bullscowsapp.gameLogic.Checker;
import pakhmutov.bullscowsapp.gameLogic.NumberGenerator;
import pakhmutov.bullscowsapp.repositories.GameRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final Checker checker;
    private final NumberGenerator numberGenerator;

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
    public String check(List<Integer>userList, List<Integer> sample){
        return checker.check(userList, sample);
    }

    //@Query(value = "INSERT INTO Game VALUES (:username, :userNumber, :animalCode)", nativeQuery = true)
    public void add(String username, List<Integer> userNumber, String animalCode){
        gameRepository.save(new Game(username, userNumber, animalCode));
    }


    public boolean isVictory() {
        String animalCode = null;
        return animalCode.equals("4Б0К");
    }


}
