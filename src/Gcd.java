import java.util.Scanner;

public class Gcd {

    public static long calc(int n, int b) {
        int max = Integer.max(n ,b);
        int min = Integer.min(n ,b);

        if (min == 0) return max;
        if (min == 1) return 1;
        System.out.println(n);
        System.out.println(b);

        return calc(min, max % min);

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(calc(a, b));
    }
}
