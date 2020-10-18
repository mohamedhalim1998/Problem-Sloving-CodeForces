package B;

import java.util.Scanner;

public class CF215_D2_B {
    public static void main(String[] args) {
        // time reading 4 min
        // think 10 min
        // implement time 10 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] r1 = new int[n];
        for (int i = 0; i < n; i++) {
            r1[i] = scanner.nextInt();
        }
        n = scanner.nextInt();
        int[] p1 = new int[n];
        for (int i = 0; i < n; i++) {
            p1[i] = scanner.nextInt();
        }
        n = scanner.nextInt();
        int[] p2 = new int[n];
        for (int i = 0; i < n; i++) {
            p2[i] = scanner.nextInt();
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int R1 = chooseR(r1);
        double r2 = Integer.MIN_VALUE;
        for (int i : p1) {
            for (int j : p2) {
                double c = caculateR2(R1, i, j, a, b);
                if (c > r2) {
                    r2 = c;
                }
            }
        }

        System.out.println(r2);
    }

    private static double caculateR2(int r1, int p1, int p2, int a, int b) {

        return Math.sqrt((Math.pow(r1, 2) * b * p1) / (a * p2 + b * p1));
    }

    private static int chooseR(int[] r1) {
        int max = Integer.MIN_VALUE;
        for (int i : r1) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }


}
