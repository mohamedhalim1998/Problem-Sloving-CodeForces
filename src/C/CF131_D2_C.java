package C;

import java.util.Scanner;

public class CF131_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        long t = scanner.nextInt();
        long ans = 0;

        for (long i = 4; i <= n; i++) {
            long j = t - i;
            if (j <= m && j >= 1) {
                ans += nCr(n, i) * nCr(m, j);
            }
        }
        System.out.println(ans);
    }

    public static long nCr(long n, long r) {
        long ans = 1;
        for (int k = 0; k < r; k++) {
            ans = ans * (n - k) / (k + 1);
        }

        return ans;
    }
}

