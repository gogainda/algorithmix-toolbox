import java.util.Scanner;

public class Change {


    public static int getChange(int m) {
        if (m == 0) {
            return 0;
        }

        if (m % 10 == 0)
            return 1 + getChange(m - 10);
        if (m % 5 == 0)
            return 1 + getChange(m - 5);
        if (m % 1 == 0)
            return 1 + getChange(m - 1);


        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

