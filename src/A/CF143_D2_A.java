package A;

import java.util.Scanner;

public class CF143_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 7 min
        // implement time 3 min
        // debug 5 min
        Scanner scanner = new Scanner(System.in);
        int r1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int d1 = scanner.nextInt();
        int d2 = scanner.nextInt();
        int x1 = (r1 - d2 + c1) / 2;
        int x2 = r1 - x1;
        int x3 = c1 - x1;
        int x4 = d1 - x1;
        if (x1 <= 0 || x2 <= 0 || x3 <= 0 || x4 <= 0) {
            System.out.println(-1);
            return;
        }
        if (x1 == x2 || x1 == x3 || x1 == x4 || x2 == x3 || x2 == x4 || x3 == x4) {
            System.out.println(-1);
            return;
        }
        if (x1 > 9 || x2 > 9 || x3 > 9 || x4 > 9) {
            System.out.println(-1);
            return;
        }
        if (x1 + x2 == r1 && x3 + x4 == r2 && x1 + x3 == c1 && x4 + x2 == c2 && x1 + x4 == d1 && x3 + x2 == d2)
            System.out.println(x1 + " " + x2 + "\n" + x3 + " " + x4);
        else
            System.out.println(-1);
    }
}
