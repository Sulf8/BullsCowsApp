package pakhmutov.bullscowsapp.gameLogic;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckerTest {
    @Test
    void checkList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(0, 2, 3, 4);
        List<Integer> list3 = Arrays.asList(2, 3, 4, 0);
        List<Integer> list4 = Arrays.asList(5, 6, 7, 8);
        List<Integer> sample = Arrays.asList(1, 2, 3, 4);

        assertEquals("4Б0К", new Checker().check(list1, sample));
        assertEquals("3Б0К", new Checker().check(list2, sample));
        assertEquals("0Б3К", new Checker().check(list3, sample));
        assertEquals("0Б0К", new Checker().check(list4, sample));
    }

    @Test
    void checkListException() {
        List<Integer> list1 = null;
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sample = Arrays.asList(1, 2, 3, 4);
        assertThrows(NullPointerException.class,
                () -> {
                    new Checker().check(list1, sample);
                });
        assertThrows(NullPointerException.class,
                () -> {
                    new Checker().check(list2, null);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Checker().check(list2, sample);
                });
    }

    @Test
    void checkString() {
        String str1 = "1234";
        String str2 = "0234";
        String str3 = "2340";
        String str4 = "5678";
        String str5 = "12F34";
        List<Integer> sample = Arrays.asList(1, 2, 3, 4);

        assertEquals("4Б0К", new Checker().check(str1, sample));
        assertEquals("3Б0К", new Checker().check(str2, sample));
        assertEquals("0Б3К", new Checker().check(str3, sample));
        assertEquals("0Б0К", new Checker().check(str4, sample));
        assertEquals("4Б0К", new Checker().check(str5, sample));
    }

    @Test
    void checkStringException() {
        String str1 = null;
        String str2 = "12345";
        List<Integer> sample = Arrays.asList(1, 2, 3, 4);
        assertThrows(NullPointerException.class,
                () -> {
                    new Checker().check(str1, sample);
                });
        assertThrows(NullPointerException.class,
                () -> {
                    new Checker().check(str2, null);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Checker().check(str2, sample);
                });
    }
}