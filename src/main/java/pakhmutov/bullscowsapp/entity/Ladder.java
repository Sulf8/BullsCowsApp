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
    @Id
    private String username;
    private int countOfTrys;
}
