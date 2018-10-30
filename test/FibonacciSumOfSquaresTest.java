import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSumOfSquaresTest {

    @Test
    public void zeroFib() {
//        assertEquals(4, FibonacciSumOfLastDigit.calc_fib(3));
    }


//    public void oneFib() {
//        assertEquals(5, FibonacciSumOfLastDigit.calc_fib(100));
//    }


    @Test
    public void oneFib2() {
        assertEquals(3, FibonacciSumOfSumOfSquares.calc_fib(new BigInteger("7")));
    }


}
