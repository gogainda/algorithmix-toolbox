import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSumOfLastDigitTest {

    @Test
    public void zeroFib() {
//        assertEquals(4, FibonacciSumOfLastDigit.calc_fib(3));
    }


//    public void oneFib() {
//        assertEquals(5, FibonacciSumOfLastDigit.calc_fib(100));
//    }


    @Test
    public void oneFib2() {
        assertEquals(0, FibonacciSumOfLastDigit.calc_fib(new BigInteger("99999999999999999")));
    }


}
