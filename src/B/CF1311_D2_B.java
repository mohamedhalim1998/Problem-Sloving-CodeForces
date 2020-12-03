package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF1311_D2_B {
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
        int[] arr = nextArray(scanner, n);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < p; i++) {
            set.add(scanner.nextInt() - 1);
        }
        for (int i = n - 1; i > 0; i--) {

            int j = i - 1;
            while (j >= 0 && set.contains(j)) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j--;
            }

        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
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
