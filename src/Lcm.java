import java.util.Scanner;

public class Lcm {
    public static long calc(int a, int b) {

        long top = (long) a * b;
        int max = Integer.max(a ,b);
        int min = Integer.min(a ,b);
        int tenPercent = min / 10;

        if (min == max) {
            return min;
        }
        if (min == 1) {
            return  max;
        }

        if (max - min == 1) {
            return top;
        }
       return  max/gcd(a,b) * min;
    }

    public static long gcd(int n, int b) {
        int max = Integer.max(n ,b);
        int min = Integer.min(n ,b);

        if (min == 0) return max;
        if (min == 1) return 1;

        return gcd(min, max % min);

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(calc(a, b));
    }

//    long maxZeros = (long) Math.pow(10, String.valueOf(max).length() - 1);
//    long minZeros = (long) Math.pow(10, String.valueOf(min).length() - 1);
//    long startingWith = (maxZeros * minZeros) / max + 1;
//        System.out.println(startingWith + 1);
//        System.out.println(startingWith * max);
//        for(long i = (startingWith * max); i < top; i = i + max) {
//        if(i > 1999999991000000000L && i < 1999999999000000000L) {
//            System.out.println(i);
//        }
//
//        if (i % min == 0 && i % max == 0) {
//            return i;
//        }
//    }
}
