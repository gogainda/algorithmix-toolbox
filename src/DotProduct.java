import java.util.*;
import java.util.stream.Collectors;

public class DotProduct {
    public static long maxDotProduct(long[] a, long[] b) {
        return naive(a, b);
    }

    public static long naive(long[] a, long[] b) {
        //write your code here
        List<Long> aList = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Long> bList = Arrays.stream(b).boxed().collect(Collectors.toList());

        aList.sort(Collections.reverseOrder());
        bList.sort(Collections.reverseOrder());
        if (a.length == 0) {
            return 0;
        }
        long result =0;

        if (aList.get(0) > 0) {
            if (bList.get(0) > 0) {
                result += aList.get(0) * bList.get(0);//both positive
            } else {
                result += aList.get(0) * bList.get(0);//3 -1
            }
            aList.remove(0);
            bList.remove(0);

        } else {
            if (bList.get(0) < 0) {
                Long maxNegativeA  = aList.get(aList.size() - 1);
                Long maxNegativeB  = bList.get(bList.size() - 1);
                result += maxNegativeA * maxNegativeB;//both positive
                aList.remove(aList.size() - 1);
                bList.remove(bList.size() - 1);
            } else {
                result += aList.get(0) * bList.get(0);//both positive
                aList.remove(0);
                bList.remove(0);
            }
        }

//        long result = 0;
//        int maxA = -1;
//        int maxB = -1;
//        int maxProduct = a[0] * b[0];
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++) {
//                if (a[i] * b[j] > maxProduct) {
//                    maxProduct = a[i] * b[j];
//                    maxA = i;
//                    maxB = j;
//                }
//            }
//        }
//        System.out.println("maxA" + maxA + "maxB" + maxB);
//        aList.remove(maxA);
//        bList.remove(maxB);

        return result + naive(aList.stream().mapToLong(i->i).toArray(), bList.stream().mapToLong(i->i).toArray());
    }

    private static Integer getNegativeMin(List<Integer> bList) {
        return bList.get(bList.size() - 1);
    }

    private static Integer getNegativeMax(List<Integer> bList) {
        return bList.stream().filter(el -> el < 0).findFirst().get();
    }

    private static Integer getPositiveMaximum(List<Integer> bList) {
        return bList.get(0);

    }

    private static Comparator<Integer> getIntegerComparator() {
        return (o1, o2) -> {
            if (o1 < 0 && o2 < 0) {

                return o2.compareTo(o1);
            } else {
                return o1.compareTo(o2);
            }

        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

