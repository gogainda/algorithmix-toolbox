import java.util.Scanner;

public class FibonacciLastDigit {
    public static long calc_fib(int n) {
        int[] resultAry = new int[n + 2];
        resultAry[0] = 0;
        resultAry[1] = 1;

        for (int i = 2; i <= n; i++) {
            resultAry[i] = (resultAry[i - 2] + resultAry[i - 1]) % 10;
        }

        return resultAry[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}