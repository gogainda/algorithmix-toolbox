import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElementTest {
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
                "2 3 9 2 2";
        provideInput(input);

        MajorityElement.main(new String[0]);

        String expected = "2\n" +
                "3 6 ";
        assertEquals(expected, getOutput());
    }
}

