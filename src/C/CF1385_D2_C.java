package C;

import java.util.ArrayList;
import java.util.Scanner;

public class CF1385_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] a = nextArray(scanner, n);

        if (n <= 2) {
            System.out.println(0);
            return;
        }
        int x = n - 1;
        while (x > 0 && a[x - 1] >= a[x]) {
            x--;
        }
        while (x > 0 && a[x - 1] <= a[x]) {
            x--;
        }
        System.out.println(x);


    }


    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

}
