package A;

import java.util.Scanner;

public class CF71_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 5 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (s.length() > 10) {
                System.out.println(""+s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1));
            } else {
                System.out.println(s);
            }
        }
    }
}
