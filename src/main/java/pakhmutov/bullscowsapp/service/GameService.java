package pakhmutov.bullscowsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.gameLogic.Checker;
import pakhmutov.bullscowsapp.gameLogic.NumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * взаимодействие с основным полем игры
 */
@Service
@RequiredArgsConstructor
public class GameService {
    private final Checker checker;
    private final NumberGenerator numberGenerator;

    /**
     * @deprecated не используется ввиду необходимости использоваения статической версии метода generateNumber(int i)
     * класса NumberGenerator
     */
    public List<Integer> generate(int i) {
        List<Integer> result = new ArrayList<>();
        try {
            result = numberGenerator.generateNumber(i);//ссылка на старую, нестатическую версию метода
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод, проверяющий соответствие введённого и загаданного чисел
     * @param userNumber комбинация цифр, введённая пользователем
     * @param sample образец для сравнения
     * @return строка с количеством быков и коров, по которой можно оценить успех попытки угадывания
     */
    public String check(List<Integer> userNumber, List<Integer> sample) {
        String result = "";
        try {
            result = checker.check(userNumber, sample);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод, проверяющий соответствие введённого и загаданного чисел
     * @param userNumberStr комбинация цифр, введённая пользователем в виде строки
     * @param sample образец для сравнения
     * @return строка с количеством быков и коров, по которой можно оценить успех попытки угадывания
     */
    public String check(String userNumberStr, List<Integer> sample) {
        String result = "";
        try {
            result = checker.check(userNumberStr, sample);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }
}
