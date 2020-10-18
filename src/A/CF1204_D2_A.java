package A;

import java.util.Scanner;

public class CF1204_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        long count = (s.length() - 1) / 2;
        if (s.substring(1).contains("1") || (s.length() % 2 == 0)) {
            count++;
        }
        System.out.println(count);
    }
}
