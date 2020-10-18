package A;

import java.util.*;

public class CF520_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 26) {
            System.out.println("NO");
            return;
        }
        int set = (int) scanner.next().toLowerCase().chars().distinct().count();

        if (set == 26) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
