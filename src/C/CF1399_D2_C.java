package C;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF1399_D2_C {
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
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        int max = 0;
        for (int s : set) {
            int count = 0;
            for (int i = 0, j = n - 1; j > i; ) {
                if (arr[i] + arr[j] > s) {
                    j--;
                } else if (arr[i] + arr[j] < s) {
                    i++;
                } else {
                    count++;
                    j--;
                    i++;
                }
            }
            if (count > max) {
                max = count;
            }
        }

        System.out.println(max);

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
