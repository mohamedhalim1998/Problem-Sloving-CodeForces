package D1A;

import java.util.Arrays;
import java.util.Scanner;

public class CF461_D1_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        Arrays.sort(arr);
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + arr[i];
        }
        long sum = sums[n];
        for (int i = 0; i < n-1; i++) {
            sum += sums[n] - sums[i];
        }
        System.out.println(sum);

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
