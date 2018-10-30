import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static void quickSort(int[] array, int lo, int hi) {
        if (hi <= lo)
            return;

        int lowerIndex = lo;
        int greaterIndex = hi;
        int element = array[lo];
        int i = lo;

        while (i <= greaterIndex) {
            if (array[i] < element)
                swap(array, lowerIndex++, i++);
            else if (array[i] > element)
                swap(array, i, greaterIndex--);
            else
                i++;
        }

        quickSort(array, lo, lowerIndex - 1);
        quickSort(array, greaterIndex + 1, hi);
    }

    // O(n)
    private static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1); // random between 0 and i
            swap(ar, i, index);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        quickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

