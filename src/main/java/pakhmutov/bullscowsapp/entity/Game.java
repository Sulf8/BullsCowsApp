package pakhmutov.bullscowsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * сущность игры
 */
@Data
@NoArgsConstructor
public class Game {
    @Id //подойдёт без явного прописания стратегии?
    private int id;
    private String username;
    private List<Integer> userNumber;
    private String animalCode;

    public Game(String username, List<Integer> userNumber, String animalCode) {
    }
}
