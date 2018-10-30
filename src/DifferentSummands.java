import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        summands.add(0);

        int sum = 0;
        for (int i = 1; i <= n && sum < n; i++) {
            if ((i + sum) ==n) {
                summands.add(i);
                sum += i;
                break;
            }
            if(n - (sum  + i) >= (i + 1)) {
                summands.add(i);
                sum +=i;
            }
        }
        //write your code here
        return summands.subList(1, summands.size());
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

