import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class InversionsTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testCase1() {
        final String input = "5\n" +
                "2 3 9 2 9";
        provideInput(input);

        Inversions.main(new String[0]);

        String expected = "2";
        assertEquals(expected, getOutput());
    }

    @Test
    public void testCase2() {
        final String input = "5\n" +
                "3 4 5 1 2";
        provideInput(input);

        Inversions.main(new String[0]);

        String expected = "2";
        assertEquals(expected, getOutput());
    }

    @Test
    public void testCase6() {
        final String input = "6\n" +
                "6 3 9 1 2 7";
        provideInput(input);

        Inversions.main(new String[0]);

        String expected = "2";
        assertEquals(expected, getOutput());
    }

    @Test
    public void testCase10() {
        final String input = "6\n" +
                "1 5 2 5 6 3";
        provideInput(input);

        Inversions.main(new String[0]);

        String expected = "2";
        assertEquals(expected, getOutput());
    }

    @Test
    public void testCase3() {
        final String input = "5\n" +
                "2 3 9 2 9";
        provideInput(input);

        Inversions.main(new String[0]);

        String expected = "2";
        int[] ar = new int[]{2, 4, 4, 5, 6};
        assertEquals(0, InversionsSlow.count(ar));
       assertEquals(expected, getOutput());
    }

    @Test
    public void testCase4() {
        for (int i = 0; i < 10000; i++) {
            int lenght = ThreadLocalRandom.current().nextInt(1, 10);
            int[] array = new int[lenght];
            int[] array2 = new int[lenght];
            int[] array3 = new int[lenght];
            for (int j = 0; j < array.length; j++) {
                array[j] = ThreadLocalRandom.current().nextInt(1, 10);
            }
            int[] copy1 = array.clone();
            int[] copy2 = array.clone();
            int[] copy3 = array.clone();
            long actual = Inversions.getNumberOfInversions(copy1, array2, 0, array.length -1);
            long expected = InversionsSlow.count(copy2);
            if (actual != expected) {
                System.out.println("slow" + expected + "fast" + actual);
                System.out.println(Arrays.toString(copy3));
                break;
            }
        }
    }

}