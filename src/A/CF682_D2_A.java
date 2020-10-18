package A;

import java.util.Scanner;

public class CF682_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 15 min
        // implement time 2 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        long count = 0;
        for (int i = 1; i <= min; i++) {
            count += ((i % 5) + max) / 5;

        }
        System.out.println(count);
    }
}
