import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciLastDigitTest {

    @Test
    public void zeroFib() {
        assertEquals(0, FibonacciLastDigit.calc_fib(0));
    }

    @Test
    public void oneFib() {
        assertEquals(1, FibonacciLastDigit.calc_fib(1));
    }


    @Test
    public void  twoFib() {
        assertEquals(1, FibonacciLastDigit.calc_fib(2));
    }

    @Test
    public void nthFib() {
        assertEquals(5, FibonacciLastDigit.calc_fib(100));
    }
}
