package pakhmutov.bullscowsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LadderAVG implements LadderStatistic {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;*/
    private String username;
    private int AVGCountOfTrys;

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public int getCount() {
        return AVGCountOfTrys;
    }
}
