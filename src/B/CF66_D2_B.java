package B;

import java.util.Scanner;

public class CF66_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 3 min
        // implement time 5 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i; j < n - 1; j++) {
                if (h[j] >= h[j + 1]) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = i; j > 0; j--) {
                if (h[j] >= h[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
    }
}
