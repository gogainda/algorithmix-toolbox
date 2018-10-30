import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSumOfLastDigit2Test {

    @Test
    public void zeroFib() {
        assertEquals(2, FibonacciSumOfLastDigit2.calc_fib(new BigInteger("10"), new BigInteger("200")));
    }
    @Test
    public void zeroFib2() {
        assertEquals(2, FibonacciSumOfLastDigit2.calc_fib(new BigInteger("1"), new BigInteger("2")));
    }

    @Test
    public void oneFib() {
        assertEquals(5, FibonacciSumOfLastDigit2.calc_fib(new BigInteger("10"), new BigInteger("10")));
    }

    @Test
    public void threeAndSeven() {
        assertEquals(1, FibonacciSumOfLastDigit2.calc_fib(new BigInteger("3"), new BigInteger("7")));
    }



}
