package pakhmutov.bullscowsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

/**
 * сущность игры
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    @ElementCollection
    private List<Integer> userNumber;
    private String animalCode;

    public Game(String username, List<Integer> userNumber, String animalCode) {
        this.username = username;
        this.userNumber = userNumber;
        this.animalCode = animalCode;
    }
}
