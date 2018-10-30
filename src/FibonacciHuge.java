import java.util.*;

public class FibonacciHuge {
    public static long getFibonacciHugeNaive(long n, long m) {
        List<Long> fibNums = new ArrayList<>();
        fibNums.add(0l);
        fibNums.add(1l);



        for (int i = 2; !periodIsFound(fibNums); i++) {
            fibNums.add((fibNums.get(i - 2) + fibNums.get(i - 1)) % m);

        }

        return fibNums.get((int) (n % (fibNums.size() - 2)));
    }

    private static boolean periodIsFound(List<Long> period) {
        if( period.get(period.size() - 1) == 1 && period.get(period.size() - 2) == 0 && period.size() != 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
