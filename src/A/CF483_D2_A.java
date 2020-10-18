package A;

import java.util.Scanner;

public class CF483_D2_A {
    public static void main(String[] args) {
        // reading time 3 min
        // think time 1 min
        // implement time 3 min
        // debug time 10 min
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        if (m - n + 1 < 3) {
            System.out.println(-1);
            return;
        }

        for (long j = n; j <= m; j++) {
            long a = j;
            long b = j;
            long c = j;
            for (long i = a + 1; i < m; i++) {
                if (gcd(i, a) == 1) {
                    b = i;
                    break;
                }
            }
            for (long i = a + 1; i <= m; i++) {
                if (gcd(a, i) != 1 && gcd(b, i) == 1 && i != b) {
                    c = i;
                    break;
                }
            }
            if (a != b && a != c) {
                System.out.println(a + " " + b + " " + c);
                return;
            }
        }
        System.out.println(-1);
    }

    static long gcd(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
