package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF567_D2_A {
    public static void main(String[] args) {
        // time reading 1 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Math.abs(arr[1] - arr[0]) + " " + Math.abs(arr[n - 1] - arr[0]));
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(Math.abs(arr[i] - arr[i - 1]), Math.abs(arr[i] - arr[i + 1]));
            int max = Math.max(Math.abs(arr[i] - arr[n - 1]), Math.abs(arr[i] - arr[0]));
            System.out.println(min + " " + max);
        }
        System.out.println(Math.abs(arr[n - 1] - arr[n - 2]) + " " + Math.abs(arr[n - 1] - arr[0]));


    }
}
