package A;

import java.util.Scanner;

public class CF1365_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = scanner.nextInt();
                if (x == 1) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (rows[i] == 0) {
                a++;
            }
        }
        for (int i = 0; i < m; i++) {
            if (cols[i] == 0) {
                b++;
            }
        }
        int count = Math.min(a, b);
        if (count % 2 == 0) {
            System.out.println("Vivek");
            ;
        } else {
            System.out.println("Ashish");
        }
    }
}
