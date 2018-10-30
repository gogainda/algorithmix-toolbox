import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @Test
    public void zeroFib() {
        assertEquals(0, Fibonacci.calc_fib(0));
    }

    @Test
    public void oneFib() {
        assertEquals(1, Fibonacci.calc_fib(1));
    }


    @Test
    public void  twoFib() {
        assertEquals(1, Fibonacci.calc_fib(2));
    }

    @Test
    public void nthFib() {
        assertEquals(55, Fibonacci.calc_fib(10));
    }
}
