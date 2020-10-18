package B;

import java.util.Scanner;

public class CF415_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        for (long i = 0; i < n; i++) {
            long x = scanner.nextLong();
            long s = x * a % b;
            s = s / a;
            System.out.print(s + " ");
        }
    }
}
