package C;

import java.util.Scanner;

public class CF1352_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long ans = k + (k - 1) / (n - 1);
        System.out.println(ans);
    }
}
