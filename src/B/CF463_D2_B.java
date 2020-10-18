package B;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF463_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 3 min
        // implement time 2 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[n - 1]);
    }
}
