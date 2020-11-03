package A;

import java.util.Scanner;

public class CF1334_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }

        if (c[0] > p[0]) {
            System.out.println("NO");
            return;
        }

        for (int i = 1; i < n; i++) {

            if (c[i] > p[i] || p[i] < p[i - 1] || c[i] < c[i - 1] || (p[i] - p[i - 1] < c[i] - c[i - 1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
