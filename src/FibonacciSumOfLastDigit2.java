import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSumOfLastDigit2 {
    public static int calc_fib(BigInteger m, BigInteger n) {
        if (n.intValue() == 0) {
            return 0;
        }

        List<Long> fibNums = new ArrayList<>();
        fibNums.add(0l);
        fibNums.add(1l);



        for (int i = 2; !periodIsFound(fibNums); i++) {
            fibNums.add(((fibNums.get(i - 2) % 10) + (fibNums.get(i - 1) % 10)) % 10);

        }
        List<Long> period = new ArrayList<>(fibNums.subList(0, fibNums.size() - 2));
        int indexOfMInPeriod = m.mod(new BigInteger(String.valueOf(period.size()))).intValue();
        int indexOfNInPeriod = n.mod(new BigInteger(String.valueOf(period.size()))).intValue();


        return fibNums.subList(indexOfMInPeriod, indexOfNInPeriod + 1).stream().mapToInt(Long::intValue).sum() % 10;
    }
    private static boolean periodIsFound(List<Long> period) {
        if( period.get(period.size() - 1) == 1 && period.get(period.size() - 2) == 0 && period.size() != 2) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BigInteger m = new BigInteger(in.next());
        BigInteger n = new BigInteger(in.next());

        System.out.println(calc_fib(m, n));
    }
}