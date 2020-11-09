package C;

import java.util.Scanner;

public class CF707_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();

        if (n < 3) {
            System.out.println(-1);
            return;
        }

        if (n % 2 == 1) {
            long a = (n * n - 1) / 2;
            long b = (n * n + 1) / 2;
            System.out.println(a + " " + b);
        } else {
            long a = (n * n /4) - 1;
            long b = (n * n /4) + 1;

            System.out.println(a + " " + b);
        }

    }
}
