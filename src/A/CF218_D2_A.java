package A;

import java.util.HashMap;
import java.util.Scanner;

public class CF218_D2_A {
    public static void main(String[] args) {
        // time reading 5 min
        // think 2 min
        // implement time 5 min
        // debug 5 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] points = new int[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            points[i] = scanner.nextInt();
        }
        int j = 0;
        System.out.print(points[0] + " ");
        for (int i = 1; i < 2 * n; i++) {
            if (i % 2 == 0) {
                System.out.print(points[i] + " ");
                continue;
            }
            if (points[i - 1] < points[i] - 1 && points[i + 1] < points[i] - 1 && j < k) {
                System.out.print((points[i] - 1) + " ");
                j++;
            } else {
                System.out.print((points[i]) + " ");
            }
        }
        if (j < k) {
            System.out.println((points[2 * n] - 1));
        } else {
            System.out.println((points[2 * n]));
        }
    }
}
