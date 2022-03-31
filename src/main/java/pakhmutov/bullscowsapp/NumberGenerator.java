package pakhmutov.bullscowsapp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * класс для генерации числа
 */
public class NumberGenerator {
    /**
     * набор исходных цифр
     */
    List<Integer> numberList = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

    /**
     * @param rank - разрядность числа, которое требуется сгенерировать,
     * причём он должен быть в пределах размера набора исходных цифр.
     * @return случайное число в виде списка из его цифр.
     */
    public List<Integer> generateNumber(int rank) {
        List<Integer> result = new LinkedList<>();
        int numberListSize = numberList.size();

        try {
            if (rank<=0) throw new RuntimeException();

            for (int i = 0; i < rank; i++) {
                int randomIndexOfList = (int) (Math.random() * (numberListSize-i));
                int oneOfResultNumber = numberList.get(randomIndexOfList);
                numberList.remove(randomIndexOfList);
                result.add(oneOfResultNumber);
            }
        } catch (RuntimeException e) {
            System.err.println("Попробуйте ввести другую разрядность");
            result.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        new NumberGenerator().generateNumber(4).forEach(System.out::println);
    }
}
