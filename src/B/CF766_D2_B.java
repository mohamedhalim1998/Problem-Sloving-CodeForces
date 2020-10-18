package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF766_D2_B {
    public static void main(String[] args) {
        // time reading 2 min
        // think 7 min
        // implement time 5 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int i = n - 1; i > 1; i--) {
            if (check(arr[i], arr[i - 1], arr[i - 2])) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }

    static boolean check(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
