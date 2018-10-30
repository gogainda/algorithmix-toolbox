import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        List<Long> numbers = Arrays.stream(exp.split("[\\+|\\-|\\*]")).map(Long::valueOf).collect(Collectors.toList());
        List<String> ops = Arrays.stream(exp.split("\\d+")).filter(e -> e.length() > 0).collect(Collectors.toList());
        long m[][] = new long[numbers.size()+1][numbers.size()+1];
        long M[][] = new long[numbers.size()+1][numbers.size()+1];
        int n = numbers.size();

        ArrayList<Long> numbers1 = new ArrayList();
        numbers1.add(0l);
        numbers1.addAll(numbers);
        ArrayList<String> ops1 = new ArrayList();
        ops1.add("");
        ops1.addAll(ops);

        for (int i = 1; i <= n; i++) {
            m[i][i] = numbers1.get(i);
            M[i][i] = numbers1.get(i);
        }

        for (int s = 1; s <= numbers1.size(); s++) {
            for (int i = 1; i <= n - s; i++) {
                int j = i + s;
                m[i][j] = minAndMax(i, j, m, M, ops1)[0];
                M[i][j] = minAndMax(i, j, m, M, ops1)[1];
            }
        }
      return M[1][n];
    }

    private static long[] minAndMax(int i, int j, long[][] m, long[][] M, List<String> ops) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k <= j - 1; k++) {
            long a = eval(M[i][k], M[k+1][j], ops.get(k).charAt(0));
            long b = eval(M[i][k], m[k+1][j], ops.get(k).charAt(0));
            long c = eval(m[i][k], M[k+1][j], ops.get(k).charAt(0));
            long d = eval(m[i][k], m[k+1][j], ops.get(k).charAt(0));
            min =  Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
            max =  Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));

        }
        return new long[]{min, max};

    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

