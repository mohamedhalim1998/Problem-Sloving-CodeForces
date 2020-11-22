package C;

import java.util.Scanner;

public class CF534_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long a = scanner.nextLong();
        int[] arr = nextArray(scanner, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            long x = sum - arr[i];
            long atLeast = a - x;
            long ans = 0;
            if (atLeast > 0) {
                ans += atLeast - 1;
            }
            x = n - 1;
            long atMost = a - x;
            if (atMost < arr[i]) {
                ans += arr[i] - atMost;
            }

            System.out.print(ans + " ");
        }


    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
