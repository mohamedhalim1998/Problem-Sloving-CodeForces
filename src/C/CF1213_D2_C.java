package C;

import java.util.HashSet;
import java.util.Scanner;

public class CF1213_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (long i = m; i <= n; i += m) {
            int x = (int) (i - (i / 10) * 10);
            if (!set.contains(x)) {
                sum += x;
                set.add(x);
            } else {
                sum = (n / (i - m)) * sum;
                i = (i - m) * (n / (i - m));
                set = new HashSet<>();
            }
        }
        System.out.println(sum);

    }

}
