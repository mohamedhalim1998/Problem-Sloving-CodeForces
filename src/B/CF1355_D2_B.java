package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF1355_D2_B {
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
        Arrays.sort(arr);
        int count = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            x++;
            if (x == arr[i]) {
                count++;
                x = 0;
            }
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
