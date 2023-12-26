// Troy Zhang
// Date: 3 December 2023
// I pledge my honor that I have abided by the Stevens Honor System.
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class SortTest {

    @Test
    public void testIntegerSort(){
        Sort sortObj1 = new Sort();

        Integer[] array = {10, 7, 8, 12, 4, 6};
        sortObj1.sort(array);

        String sorted = "";

        for (int a: array){
            sorted = sorted + a + " ";
        }

        assertEquals(sorted, "4 6 7 8 10 12 ");
    }

    @Test
    public void testStringSort(){
        Sort sortObj2 = new Sort();

        String[] array2 = {"cat", "elephant", "tiger", "peacock", "dog"};

        sortObj2.sort(array2);

        String sorted = "";

        for (String a: array2){
            sorted = sorted + a + " ";
        }

        assertEquals(sorted, "cat dog elephant peacock tiger ");

    }
}
