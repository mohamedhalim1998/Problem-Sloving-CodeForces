package A;

import java.math.BigInteger;
import java.util.Scanner;

public class CF584_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        if (t != 10) {
            for (int i = 0; i < n - 1; i++) {
                out.append(t);
            }
            out.append(t);
        } else {
            out.append(1);
            for (int i = 1; i < n - 1; i++) {
                out.append(0);
            }
            out.append(0);
        }

        if (out.toString().length() > n) {
            System.out.println(-1);
        } else {
            System.out.println(out.toString());
        }


    }
}
