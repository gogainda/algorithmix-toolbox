import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciHugeTest {

    @Test
    public void testCase() {
        assertEquals(1, FibonacciHuge.getFibonacciHugeNaive(2015, 3));
    }
    @Test
    public void testCase2() {
        assertEquals(151, FibonacciHuge.getFibonacciHugeNaive(2816213588l, 239));
    }



}
