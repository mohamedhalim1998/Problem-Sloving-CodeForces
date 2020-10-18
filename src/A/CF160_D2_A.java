package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF160_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        int mine = 0;
        for (int i = n - 1; i >= 0; i--) {
            mine += arr[i];
            if (mine > sum - mine) {
                System.out.println(n - i);
                return;
            }
        }

    }
}
