import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
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
        final String input = "5 1 5 8 12 13\n" +
                "5 8 1 23 1 11";
        provideInput(input);

        BinarySearch.main(new String[0]);

        String expected = "2 0 -1 0 -1";
        Assertions.assertEquals(expected, getOutput());
    }

    @Test
    public void testCase2() {
        final String input = "5 1 2 3 4 5\n" +
                "5 1 2 3 4 5";
        provideInput(input);

        BinarySearch.main(new String[0]);

        String expected = "0 1 2 3 4";
        Assertions.assertEquals(expected, getOutput());
    }




}