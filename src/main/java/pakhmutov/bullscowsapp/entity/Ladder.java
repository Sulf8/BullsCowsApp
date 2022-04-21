package pakhmutov.bullscowsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * сущность рейтинговой таблицы
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ladder {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int countOfTrys;

    public Ladder(String username, int countOfTrys) {
        this.username = username;
        this.countOfTrys = countOfTrys;
    }
}
