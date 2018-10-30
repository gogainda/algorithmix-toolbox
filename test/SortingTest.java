import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

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
        final String input = "7\n" +
                "4 6 0 1 2 3 6";
        provideInput(input);

        Sorting.main(new String[0]);

        String expected = "2 2 3 9 9";
        assertEquals(expected, getOutput());
    }

    @Test
    public void testCaseL() {
        final String input = "5\n" +
                "2 3 9 2 9";
        provideInput(input);

        Sorting.main(new String[0]);

        String expected = "2 2 3 9 9";
        assertEquals(expected, getOutput());
    }

    @Test
    public void testCase2() {
        final String input = "10\n" +
                "10 9 8 7 6 5 4 3 2 1";
        provideInput(input);

        Sorting.main(new String[0]);

        String expected = "2 2 3 9 9";
        assertEquals(expected, getOutput());
    }

    @Test
    public void testCase3() {
        final String input = "5\n" +
                "5 5 5 4 4";
        provideInput(input);

        Sorting.main(new String[0]);

        String expected = "1 2 3";
        assertEquals(expected, getOutput());
    }
    @Test
    public void testCase5() {
        final String input = "8\n" +
                "5 4 3 4 4 4 4 3";
        provideInput(input);

        Sorting.main(new String[0]);

        String expected = "1 2 3";
        assertEquals(expected, getOutput());
    }



    @Test
    public void testCase7() {


        for (int i = 0; i < 100; i++) {
            final String input = "10\n" +
                    "6 6 0 4 8 7 6 4 7 5";
            provideInput(input);
            Sorting.main(new String[0]);
            System.out.println("!!");
        }


        String expected = "1 2 3";
//        assertEquals(expected, getOutput());
    }


}