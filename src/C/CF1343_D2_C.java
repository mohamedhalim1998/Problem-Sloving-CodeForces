package C;

import java.util.Scanner;

public class CF1343_D2_C {
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
        boolean positive = false;
        if (arr[0] > 0) {
            positive = true;
        }
        long max = arr[0];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (positive) {
                if (arr[i] < 0) {
                    sum += max;
                    max = arr[i];
                    positive = false;
                } else {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
            } else {
                if (arr[i] > 0) {
                    sum += max;
                    max = arr[i];
                    positive = true;
                } else {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
            }
        }
        System.out.println(sum + max);
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

}
