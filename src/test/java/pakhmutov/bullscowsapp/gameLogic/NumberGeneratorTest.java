package pakhmutov.bullscowsapp.gameLogic;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NumberGeneratorTest {

    @Test
    void generateNumberSize() {
        for (int i = 1; i < 10; i++) {
            List<Integer> sample = NumberGenerator.generateNumber(i);
            assertTrue(sample.size()==i);
        }
    }

    @Test
    void generateNumberException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    NumberGenerator.generateNumber(0);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    NumberGenerator.generateNumber(-1);
                });
    }



}