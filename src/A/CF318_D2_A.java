package A;

import java.util.Scanner;

public class CF318_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        long n = Long.parseLong(s[0]);
        long k = Long.parseLong(s[1]);
        scanner.close();
        n = n % 2 == 0 ? n : (n + 1);
        long odd = n / 2;
        if (k <= odd) {
            System.out.println(2 * k + 1 - 2);
        } else {
            k = k - odd;
            System.out.println(2 * k);
        }
    }
}
