package pakhmutov.bullscowsapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * класс, описывающий попытки пользователя при угадывании числа
 */
@Data
@AllArgsConstructor
public class UserTry {
    private String userNumber;
    private String animalCode;
}
