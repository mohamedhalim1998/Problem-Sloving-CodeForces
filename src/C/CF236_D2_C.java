package C;

import java.util.Scanner;

public class CF236_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        int count = 2 * n + p;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                out.append(i).append(" ").append(j).append("\n");
                count--;
                if (count == 0) {
                    System.out.print(out);
                    return;
                }

            }
        }
    }
}
