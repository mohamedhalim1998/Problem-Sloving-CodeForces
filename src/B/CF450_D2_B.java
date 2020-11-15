package B;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF450_D2_B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextInt();
        long y = scanner.nextInt();
        int n = scanner.nextInt();

        //long ans = solve(n - 1);
        if (n == 1) {
            System.out.println((x + 1000000007) % 1000000007);
            return;
        }
        long[] ans = new long[13];
        long prev = x;
        long current = y;
        long next = 0;
        ans[1] = x;
        ans[2] = y;
        for (int i = 3; i < 13; i++) {
            next = current - prev;
            next = next % 1000000007;
            prev = current;
            current = next;
            ans[i] = current;
        }

        if (n < 12) {
            System.out.println((ans[n] + 1000000007) % 1000000007);
        } else {
            n = n % 6 + 6;
            System.out.println((ans[n] + 1000000007) % 1000000007);
        }



    }

}
