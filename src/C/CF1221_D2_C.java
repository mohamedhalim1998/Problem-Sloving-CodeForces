package C;

import java.util.Scanner;

public class CF1221_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int c = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        long t = c + m + x;
        if (c < m) {
            m = m - c;
            t -= 3 * c;
            if (t >= 0) {
                System.out.println(c);
            } else {
                int count = (int) (c - Math.ceil(Math.abs(t) / 3.0));
                System.out.println(count);
            }
        } else {
            c = c - m;
            t -= 3 * m;
            if (t >= 0) {
                System.out.println(m);
            } else {
                int count = (int) (m - Math.ceil(Math.abs(t) / 3.0));

                System.out.println(count);
            }
        }
    }
}
