package pakhmutov.bullscowsapp.gameLogic;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * класс для сравнения чисел
 */
@Component
public class Checker {

    /**
     * @param userNumber комбинация цифр, введённая пользователем.
     * @param sample образец для сравнения.
     * @return строка с количеством быков и коров.
     */
    public String check(List<Integer> userNumber, List<Integer> sample) {
        int bulls = 0;
        int cows = 0;
        StringBuilder animalSB = new StringBuilder();

        if (userNumber ==null || sample==null) throw new NullPointerException("пусто!");

        if (userNumber.size() != sample.size())
            throw new IllegalArgumentException("количество знаков должно быть равно " + sample.size());

        for (int i = 0; i < sample.size(); i++) {
            for (int j = 0; j < userNumber.size(); j++) {
                if (Objects.equals(sample.get(i), userNumber.get(j))) {
                    if ((i == j)) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        return animalSB.append(bulls).append("Б").append(cows).append("К").toString();
    }

    /**
     * @param userNumberStr комбинация цифр, введённая пользователем в виде строки
     * @param sample образец для сравнения
     * @return строка с количеством быков и коров
     */
    public String check(String userNumberStr, List<Integer> sample) {
        if (userNumberStr ==null ) throw new NullPointerException("пусто UserNumber!");
        if ( sample==null) throw new NullPointerException("пусто sample!");

        List<Integer> userNumber = userNumberStr.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        if (userNumber.size() != sample.size())
            throw new IllegalArgumentException("количество знаков должно быть равно " + sample.size());

        return check(userNumber, sample);
    }
}

