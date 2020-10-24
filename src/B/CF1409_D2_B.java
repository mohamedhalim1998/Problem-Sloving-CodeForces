package B;

import java.util.Scanner;

public class CF1409_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        long x = scanner.nextInt();
        long y = scanner.nextInt();
        long n = scanner.nextInt();
        long a1 = a;
        long a2 = a;
        long b1 = b;
        long b2 = b;
        long n1 = n;
        long n2 = n;
        if (a1 - x <= n1) {
            a1 = x;
            n1 = n1 - a + x;
            if (n1 > 0) {
                if (b1 - y <= n1) {
                    b1 = y;
                } else {
                    b1 = b1 - n1;
                }
            }
        } else {
            a1 = a1 - n1;
        }
        if (b2 - y <= n2) {
            b2 = y;
            n2 = n2 - b + y;
            if (n2 > 0) {
                if (a2 - x <= n2) {
                    a2 = x;
                } else {
                    a2 = a2 - n2;
                }
            }
        } else {
            b2 = b2 - n2;
        }

        System.out.println(Math.min(a1 * b1, a2 * b2));
    }

}
