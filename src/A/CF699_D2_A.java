package A;

import java.util.Scanner;

public class CF699_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 1 min
        // implement time 6 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] directions = scanner.next().toCharArray();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            p[i] = x;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int p1 = p[i];
            int p2 = p[i + 1];
            char d1 = directions[i];
            char d2 = directions[i + 1];
            if (d1 == 'R' && d2 == 'L' && Math.abs(p1 - p2) < min) {
                min = Math.abs(p1 - p2);
            }
        }
        if (min != Integer.MAX_VALUE) {
            System.out.println(min / 2);
        } else {
            System.out.println(-1);
        }
    }
}
