package pakhmutov.bullscowsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * класс, описывающий попытки пользователя при угадывании заданного числа
 */
@Data
@AllArgsConstructor
public class UserTry {
    private String userNumber;
    private String animalCode;
}
