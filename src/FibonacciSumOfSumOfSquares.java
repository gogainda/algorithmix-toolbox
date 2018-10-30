import java.math.BigInteger;
import java.util.*;

public class FibonacciSumOfSumOfSquares {
    public static int calc_fib(BigInteger n) {
        return (int) (modOfSquare(n) * modOfSquare(n.add(BigInteger.ONE))) % 10;
    }

    public static Long modOfSquare(BigInteger n) {
        if (n.intValue() == 0) {
            return 0l;
        }

        List<Long> fibNums = new ArrayList<>();
        fibNums.add(0l);
        fibNums.add(1l);



        for (int i = 2; !periodIsFound(fibNums); i++) {
            fibNums.add(((fibNums.get(i - 2) % 10) + (fibNums.get(i - 1) % 10)) % 10);

        }
        List<Long> period = new ArrayList<>(fibNums.subList(0, fibNums.size() - 2));
        int indexInPeriod = n.mod(new BigInteger(String.valueOf(period.size()))).intValue();
        int indexPlusOne = indexInPeriod + 1;

        return fibNums.get(indexInPeriod);
    }

    private static boolean periodIsFound(List<Long> period) {
        if( period.get(period.size() - 1) == 1 && period.get(period.size() - 2) == 0 && period.size() != 2) {
            return true;
        }
        return false;
    }

    public static BigInteger[] fib(int n) {
        BigInteger[] resultAry = new BigInteger[n + 2];
        resultAry[0] = BigInteger.ZERO;
        resultAry[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            resultAry[i] = resultAry[i - 2].add(resultAry[i - 1]);
        }

        return resultAry;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BigInteger n = new BigInteger(in.next());

        System.out.println(calc_fib(n));
    }
}