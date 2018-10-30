import java.util.*;

public class PrimitiveCalculator {
    private static Operation[] operations = new Operation[]{new Operation("+1"), new Operation("*2"), new Operation("*3")};

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(n);

        int dpArry[][] = new int[n + 1][2];//first el is zero and not used
        dpArry[0][0] = 0;
        dpArry[0][1] = -1;
        dpArry[1][0] = 0;
        dpArry[1][1] = -1;


        for (int i = 2; i < dpArry.length; i++) {
            int minOps = Integer.MAX_VALUE;
            int minOpsIdx = -1;
            for (Operation op : operations) {

                if (op.op.equalsIgnoreCase("+1")) {
                    int j = i - 1;
                        if (op.calc(j) == i) {
                            if ((dpArry[j][0] + 1) < minOps) {
                                minOps = (dpArry[j][0] + 1);
                                minOpsIdx = j;
                            }
                        }
                }

                if (op.op.equalsIgnoreCase("*2")) {
                    int j = i / 2;
                        if (op.calc(j) == i) {
                            if ((dpArry[j][0] + 1) < minOps) {
                                minOps = (dpArry[j][0] + 1);
                                minOpsIdx = j;
                            }
                        }
                }
                if (op.op.equalsIgnoreCase("*3")) {
                    int j = i / 3;
                        if (op.calc(j) == i) {
                            if ((dpArry[j][0] + 1) < minOps) {
                                minOps = (dpArry[j][0] + 1);
                                minOpsIdx = j;
                            }
                        }
                }


            }

            dpArry[i][0] = minOps;
            dpArry[i][1] = minOpsIdx;


        }
        int trackBackIdx = dpArry.length - 1;
        while (trackBackIdx > 0) {
            if (dpArry[trackBackIdx][1] > 0) {
                sequence.add(dpArry[trackBackIdx][1]);
            }

            trackBackIdx = dpArry[trackBackIdx][1];
        }

        Collections.reverse(sequence);

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

    private static class Operation {
        private final String op;

        Operation(String op) {
            this.op = op;
        }

        int calc(int input) {
            if (op.equalsIgnoreCase("+1")) {
                return input + 1;
            }
            if (op.equalsIgnoreCase("*2")) {
                return input * 2;
            }
            if (op.equalsIgnoreCase("*3")) {
                return input * 3;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "op='" + op + '\'' +
                    '}';
        }
    }
}

