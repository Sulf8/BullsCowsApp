package pakhmutov.bullscowsapp.gameLogic;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * класс для сравнения чисел
 */
@Component
public class Checker {

    /**
     * @param userNumber комбинация цифр, введённая пользователем.
     * @param sample   образец для сравнения.
     * @return строка с количеством быков и коров.
     * @see ..... обеспечение корректности цифр из userList.
     */
    public String check(List<Integer> userNumber, List<Integer> sample) {
        int bulls = 0;
        int cows = 0;
        StringBuilder animalSB = new StringBuilder();

        if (userNumber.size() != sample.size())
            throw new IllegalArgumentException("количество знаков должно быть равно " + sample.size());

        //TODO страшно, желательно переписать
        for (int i = 0; i < sample.size(); i++) {
            for (int j = 0; j < userNumber.size(); j++) {
                if ((int) sample.get(i) == userNumber.get(j)) {
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

    //TODO добавить нормальный тест
    public static void main(String[] args) {
        List<Integer> sample = new NumberGenerator().generateNumber(4);
        sample.forEach(System.out::print);
        System.out.println();

        String str = new Checker().check(new LinkedList<>(Arrays.asList(5, 2, 3, 0)), sample);
        System.out.println(str);
    }
}

