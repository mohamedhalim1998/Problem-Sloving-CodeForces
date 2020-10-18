package B;

import java.util.Scanner;

public class CF584_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() * 3;
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= 3;
            ans = ans % 1000000007;
        }
        long m = 1;
        for (int i = 0; i < n / 3; i++) {
            m *= 7;
            m = m % 1000000007;
        }
        System.out.println((ans - m + 1000000007) % 1000000007);
    }
}
