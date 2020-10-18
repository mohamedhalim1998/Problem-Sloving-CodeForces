package B;

import java.util.Scanner;

public class CF1051_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        StringBuilder out = new StringBuilder();
        for (long i = l; i < r; i+=2) {
            if (gcd(i, i + 1) == 1) {
                out.append(i).append(' ').append(i + 1).append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        out.insert(0, "YES\n");
        System.out.print(out);
    }

    static long gcd(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
