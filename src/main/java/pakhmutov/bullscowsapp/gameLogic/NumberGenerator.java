package pakhmutov.bullscowsapp.gameLogic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * класс для генерации числа
 */
@Component
public class NumberGenerator {
    /**
     * набор исходных цифр
     */
    private static final List<Integer> numberList = new ArrayList<>(){
        {
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
        }
    };

    /**
     * @param rank разрядность числа, которое требуется сгенерировать,
     *             причём он должен быть в пределах размера набора исходных цифр.
     * @return случайное число в виде списка из его цифр.
     */
    public static List<Integer> generateNumber(int rank) {
        if (rank <= 0) throw new IllegalArgumentException("Попробуйте ввести другую разрядность");
       List<Integer> result = new ArrayList<>();

            for (int i = 0; i < rank; i++) {
                int randomIndexOfList = (int) (Math.random() * (10 - i));
                int oneOfResultNumber = numberList.get(randomIndexOfList);
                numberList.remove(randomIndexOfList);//эта строка раньше вызывала OOBException, потом перестала
                result.add(oneOfResultNumber);
            }
        return result;
    }
}

