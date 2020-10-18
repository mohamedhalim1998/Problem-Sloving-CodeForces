package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF381_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 2 min
        // implement time 3 min
        // debug  3 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean serejaRule = true;
        int sereja = 0;
        int dima = 0;
        for (int i = 0, j = n - 1; i <= j; ) {
            if (serejaRule) {
                if (arr[i] > arr[j]) {
                    sereja += arr[i];
                    i++;
                } else {
                    sereja += arr[j];
                    j--;
                }
                serejaRule = false;
            } else {
                if (arr[i] > arr[j]) {
                    dima += arr[i];
                    i++;
                } else {
                    dima += arr[j];
                    j--;
                }
                serejaRule = true;
            }

        }
        System.out.println(sereja + " " + dima);
    }
}
