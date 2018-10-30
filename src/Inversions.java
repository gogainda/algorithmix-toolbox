import java.util.Scanner;

public class Inversions {

    public static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            b[left] = a[left];
            return 0;
        }
        int mid = left + (right - left) / 2;
        long ml = getNumberOfInversions(a, b, left, mid);
        long mr = getNumberOfInversions(a, b, mid + 1, right);
        return ml + mr + merge(a, b, left, right, mid);
    }

    private static long merge(int[] orig, int[] res, int left, int right, int mid) {
        int inversions = 0;
        int leftPartIdx = left;
        int rightPartIdx = mid + 1;
        int k = left;
        while (leftPartIdx <= mid || rightPartIdx <= right) {
            if (leftPartIdx <= mid && rightPartIdx <= right) {
                if (orig[leftPartIdx] <= orig[rightPartIdx]) {
                    res[k] = orig[leftPartIdx];
                    leftPartIdx++;
                } else {
                    if (orig[leftPartIdx] > orig[rightPartIdx]) {
                        res[k] = orig[rightPartIdx];
                        inversions += rightPartIdx - k;
                        rightPartIdx++;


                    }
                }
            } else if (leftPartIdx > mid) {
                res[k] = orig[rightPartIdx];
                inversions += rightPartIdx - k;
                rightPartIdx++;
            } else if (rightPartIdx > right){
                res[k] = orig[leftPartIdx];
                leftPartIdx++;
            }
            k++;

        }
        for (int l = left; l <= right ; l++) {
            orig[l] = res[l];

        }
        return inversions;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
    }
}

