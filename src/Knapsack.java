import java.util.*;
import java.util.stream.Collectors;

public class Knapsack {
    static int optimalWeight(int W, int[] wa) {

        int n = wa.length;
        ArrayList<Integer> wal = new ArrayList();
        wal.add(0);
        wal.addAll(Arrays.stream(wa).boxed().collect(Collectors.toList()));


        int[][] dpMatrix = new int[W + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                dpMatrix[w][i] = dpMatrix[w][i-1];
                if (wal.get(i) <= w) {
                    int val = dpMatrix[w - wal.get(i)][i - 1] + wal.get(i);
                    if (dpMatrix[w][i] < val) {
                        dpMatrix[w][i] = val;
                    }

                }

            }

        }
        return dpMatrix[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

