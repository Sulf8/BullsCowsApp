package pakhmutov.bullscowsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * сущность рейтинговой таблицы
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ladder {
    //private int rank;
    @Id
    private String username;
    /**
     * поле с средним количестсвом попыток до угадывания числа
     */
    private int AVGcountOfTrys;
}
