import java.util.Scanner;
import java.util.stream.IntStream;

public class ChangeDP {
    private static int[] coins = new int[]{1,3,4};
    private static int getChange(int m) {
        int dpArry[] = new int[m + 1];


        for (int i = 1; i < dpArry.length; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                int j = i;
                while (j >= 0) {
                    if ((j + coin) == i) {
                        if ((dpArry[j] + 1) < minCoins) {
                            minCoins = (dpArry[j] + 1);
                        }
                    }
                    j--;
                }

            }

            dpArry[i] = minCoins;

        }
        return dpArry[dpArry.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

