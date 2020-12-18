package B;

import java.util.Scanner;

public class CF1420_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        long count = 0;
        for (int j = 29; j >= 0; j--) {
            long c = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] >= (1 << j) && arr[i] < (1 << (j + 1)))
                    c++;
            }
            count += (c * (c - 1)) / 2;
        }
        System.out.println(count);

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
