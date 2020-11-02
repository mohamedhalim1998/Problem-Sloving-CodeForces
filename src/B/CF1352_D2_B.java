package B;

import java.util.Scanner;

public class CF1352_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int o = n;
        if (k > n) {
            System.out.println("NO");
            return;
        }

        if (n % k == 0) {
            System.out.println("YES");
            for (int i = 0; i < k; i++) {
                System.out.print((n / k) + " ");
            }
            System.out.println();
            return;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            out.append(1).append(" ");
            n--;
        }
        if (n % 2 == 1) {
            out.append(n);
            System.out.println("YES");
            System.out.println(out);
        } else {
            if (o % 2 == 0) {
                out = new StringBuilder();
                for (int i = 0; i < k - 1; i++) {
                    out.append(2).append(" ");
                    o -= 2;
                }
                if (o > 0) {
                    out.append(o);
                    System.out.println("YES");
                    System.out.println(out);
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
