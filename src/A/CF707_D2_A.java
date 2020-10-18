package A;

import java.util.Scanner;

public class CF707_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 1 min
        // implement time 5 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = n * m;
        for (int i = 0; i < x; i++) {
            char s = scanner.next().charAt(0);
            if (s == 'C' || s == 'M' || s == 'Y') {
                System.out.println("#Color");
                return;
            }
        }
        System.out.println("#Black&White");
    }
}
