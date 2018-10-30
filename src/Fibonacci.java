import java.util.Scanner;

public class Fibonacci {
    public static long calc_fib(int n) {
        int[] resultAry = new int[n + 2];
        resultAry[0] = 0;
        resultAry[1] = 1;

        for (int i = 2; i <= n; i++) {
            resultAry[i] = resultAry[i - 2] + resultAry[i - 1];
        }

        return resultAry[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}

//for (int i = left + 1; i <= r; i++) {
//        if (a[i] < x) {
//        smallIndex++;
//        int t = a[i];
//        a[i] = a[smallIndex];
//        a[smallIndex] = t;
//
//        middleIndex++;
//        biggerIndex++;
//        continue;
//        }
//        if (a[i] == x) {
//        middleIndex++;
//        int t = a[middleIndex];
//        a[middleIndex] = a[i];
//        a[i] = t;
//
//        biggerIndex++;
//        continue;
//
//        }
//        if (a[i] > x) {
//
//        biggerIndex++;
//        int t = a[i];
//        a[i] = a[biggerIndex];
//        a[biggerIndex] = t;
//
//        continue;
//        }
//        }
//
//
//        int t = a[left];
//        if (a[left] != a[smallIndex]) {
//        a[left] = a[smallIndex];
//        a[smallIndex] = t;
//        smallIndex--;
//        }
//
//        m[0] = smallIndex;
//        m[1] = middleIndex;